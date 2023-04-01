package mmi.alura.models;

import mmi.alura.AnsiCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filme {
    private String id;
    private Integer rank;
    private String title;
    private String fullTitle;
    private String year;
    private String image;
    private String crew;
    private Double imDbRating;
    private String imDbRatingCount;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = Integer.parseInt(rank);
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getFullTitle() {
        return fullTitle;
    }
    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getCrew() {
        return crew;
    }
    public void setCrew(String crew) {
        this.crew = crew;
    }
    public Double getImDbRating() {
        return imDbRating;
    }
    public String getImDbRatingStars() {
        String stars = "";
        for (int i = 0; i < Math.floor(getImDbRating()); i++) stars += "*";
        return stars;
    }
    public void setImDbRating(String imDbRating) {
        this.imDbRating = Double.parseDouble(imDbRating);
    }
    public String getImDbRatingCount() {
        return imDbRatingCount;
    }
    public void setImDbRatingCount(String imDbRatingCount) {
        this.imDbRatingCount = imDbRatingCount;
    }
    public String toString() {
        return (
                AnsiCodes.ANSI_YELLOW + getImDbRatingStars() + AnsiCodes.ANSI_RESET +
                AnsiCodes.ANSI_GRAY + "\nRank: " + AnsiCodes.ANSI_RESET + getRank() +
                AnsiCodes.ANSI_GRAY + "\nTítulo: " + AnsiCodes.ANSI_RESET + getFullTitle() +
                AnsiCodes.ANSI_GRAY + "\nPoster: " + AnsiCodes.ANSI_RESET + getImage());
    }
}

