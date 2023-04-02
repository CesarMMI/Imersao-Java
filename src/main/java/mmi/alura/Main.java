package mmi.alura;

import mmi.alura.models.Apod;
import mmi.alura.models.Content;
import mmi.alura.models.FilmeResponse;
import mmi.alura.utils.AnsiCodes;
import mmi.alura.utils.Requester;
import mmi.alura.utils.StickerBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Escolha qual API quer chamar:
                [0] IMDB
                [1] Nasa""");

        int apiIndex;
        while (true) {
            apiIndex = scanner.nextInt();
            if ((apiIndex == 0) || (apiIndex == 1)) break;
            System.out.println("Indice inválido");
        }

        Content[] data = new Content[0];
        switch (apiIndex) {
            case 0 -> data = Requester.getData(
                    "https://raw.githubusercontent.com/alura-cursos" +
                        "/imersao-java-2-api/main/TopMovies.json",
                    FilmeResponse.class).items();
            case 1 -> data = Requester.getData(
                    "https://api.nasa.gov/planetary/apod" +
                        "?api_key=IvVfW6eu7vOgoEZv8Yddp4xVnnl40c2yko0b5kxn" +
                        "&count=5",
                    Apod[].class);
        }

        for (int i = 0; i < data.length; i++)
            System.out.printf("%n%sIndice: %s%s%n%s",
                    AnsiCodes.ANSI_GRAY, AnsiCodes.ANSI_RESET, i, data[i]);

        System.out.println("Escolha o item pelo índice:");
        String imageUrl;
        while (true){
            int itemIndex = scanner.nextInt();
            if (itemIndex > 0 && itemIndex < data.length){
                imageUrl = data[itemIndex].getImageUrl();
                break;
            }
            System.out.println("Indice inválido");
        }

        System.out.println("Digite sua mensagem:");
        String message = scanner.next();

        System.out.println("Digite o nome do arquivo:");
        String fileName = scanner.next();

        StickerBuilder.createSticker(imageUrl, message, fileName);
    }

    public static void printApods() {

    }


}

