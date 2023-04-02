package mmi.alura.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class StickerBuilder {
    public static void createSticker(String urlStr, String message, String fileName) throws IOException {
        InputStream inputStream = new URL(urlStr).openStream();
        BufferedImage original = ImageIO.read(inputStream);
        BufferedImage newImage = createNewImage(original);
        drawMessageOnImage(newImage, message, original);
        saveImage(newImage, fileName);
    }

    private static BufferedImage createNewImage(BufferedImage original) {
        int newWidth = original.getWidth();
        int newHeight = (int) (original.getHeight() * 1.1);
        return new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
    }

    private static void drawMessageOnImage(BufferedImage image, String message, BufferedImage original) {
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(original, 0, 0, null);

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, getRelativeFontSize(original));
        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);

        FontMetrics fontMetrics = graphics.getFontMetrics();
        int messageWidth = fontMetrics.stringWidth(message);
        int messageX = (image.getWidth() - messageWidth) / 2;
        int messageY = (int) (original.getHeight() + (image.getHeight() - original.getHeight()) / 2.0 + fontMetrics.getAscent() / 2.0);
        graphics.drawString(message, messageX, messageY);
        graphics.dispose();
    }

    private static int getRelativeFontSize(BufferedImage original) {
        int fontSize = (int) (original.getHeight() * 0.1 * 0.8);
        return fontSize > 0 ? fontSize : 1;
    }

    private static void saveImage(BufferedImage image, String fileName) throws IOException {
        File outFolder = new File("results");
        if (!outFolder.exists()) {
            outFolder.mkdir();
        }

        File outFile = new File(outFolder, fileName + ".png");
        ImageIO.write(image, "png", outFile);
    }
}
