import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        String baseUrl = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/";
        URI uri = URI.create(baseUrl + "TopMovies.json");

        HttpClient http = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = http
                .send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();
        JsonParser parser = new JsonParser();
        List<Filme> lista = parser.parse(body);
        for ( Filme filme : lista )
            System.out.println(filme + "\n");

    }
}