package mmi.alura;

import mmi.alura.api.JsonParser;
import mmi.alura.models.Filme;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Filme> filmes = getFilmes();
        for (Filme filme : filmes)
            System.out.println(filme + "\n");

        Filme filme;
        System.out.println("Escolha um filme pelo rank:");
        while (true){
            Integer rank = scanner.nextInt();
            filme = filmes.stream()
                    .filter(f -> rank.equals(f.getRank()))
                    .findAny()
                    .orElse(null);
            if (filme != null) break;
            else System.out.println("Rank inválido");
        }

        String message = "";
        System.out.println("Digite sua mensagem:");
        message = scanner.next();

        String fileName = "";
        System.out.println("Digite o nome do arquivo:");
        fileName = scanner.next();

        StickerBuilder.build()
                .url(filme.getImage())
                .message(message)
                .fileName(fileName)
                .create();
    }

    private static List<Filme> getFilmes() throws IOException, InterruptedException {
        String baseUrl = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/";
        URI uri = URI.create(baseUrl + "TopMovies.json");

        HttpClient http = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());

        return JsonParser.build().response(response.body()).parse();
    }
}

