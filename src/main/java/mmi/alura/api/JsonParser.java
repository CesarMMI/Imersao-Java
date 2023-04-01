package mmi.alura.api;

import com.google.gson.Gson;
import mmi.alura.models.Filme;

import java.util.List;

public class JsonParser {
    private String response;

    public static JsonParser build(){
        return new JsonParser();
    }
    public JsonParser response(String response) {
        this.response = response;
        return this;
    }
    public List<Filme> parse() {
        Gson gson = new Gson();
        ApiResponse apiResponse = gson.fromJson(response, ApiResponse.class);
        return apiResponse.getItems();
    }
}

