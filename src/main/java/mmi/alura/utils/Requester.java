package mmi.alura.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requester {
    public static  <T> T getData(String url, Class<T> responseType) throws Exception {
        return convert(get(url), responseType);
    }
    private static  <T> T convert(String response, Class<T> responseType){
        Gson gson = new Gson();
        return gson.fromJson(response, responseType);
    }
    private static String get(String url) throws IOException, InterruptedException {
        URI uri = URI.create(url);
        HttpClient http = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response;

        response = http.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
