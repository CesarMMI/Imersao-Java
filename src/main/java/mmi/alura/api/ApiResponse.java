package mmi.alura.api;

import mmi.alura.models.Filme;

import java.util.List;

public class ApiResponse {
    private List<Filme> items;
    private String errorMessage;

    public List<Filme> getItems() {
        return items;
    }
    public void setItems(List<Filme> items) {
        this.items = items;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
