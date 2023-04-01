package mmi.alura;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class StickerBuilder {
    private Graphics2D graphics;
    private BufferedImage original;
    private BufferedImage result;
    private String fileName;

    public StickerBuilder() {
    }
    public static StickerBuilder build() {
        return new StickerBuilder();
    }

    public StickerBuilder url(String url) {
        InputStream inputStream = null;
        try {
            inputStream = new URL(url).openStream();
            this.original = ImageIO.read(inputStream);
        } catch (IOException e) {
            System.out.println("URL inválida");
            throw new RuntimeException(e);
        }

        int width = original.getWidth();
        int height = original.getHeight() + ((original.getHeight() / 100) * 10);
        result = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);

        graphics = (Graphics2D) result.getGraphics();
        graphics.drawImage(original, 0, 0, null);

        return this;
    }
    public StickerBuilder message(String message) {
        drawCenteredString(message);
        return this;
    }
    public StickerBuilder fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
    private void drawCenteredString(String text) {
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 128);
        FontMetrics metrics = graphics.getFontMetrics(font);

        metrics.getHeight();
        int x = (result.getWidth() - metrics.stringWidth(text)) / 2;
        int y = original.getHeight() + metrics.getAscent();

        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);
        graphics.drawString(text, x, y);
    }
    public void create() throws Exception {
        ImageIO.write(result, "png", new File(fileName + ".png"));
    }
}
