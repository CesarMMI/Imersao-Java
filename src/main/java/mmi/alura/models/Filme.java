package mmi.alura.models;

import com.google.gson.Gson;
import mmi.alura.utils.AnsiCodes;
import mmi.alura.utils.Requester;

public class Filme implements Content{
    public String id;
    public Integer rank;
    public String title;
    public String fullTitle;
    public String year;
    public String image;
    public String crew;
    public Double imDbRating;
    public String imDbRatingCount;
    public String getImDbRatingStars() {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < imDbRating; i++) stars.append("*");
        return stars.toString();
    }

    @Override
    public String getImageUrl() {
        return image;
    }
    @Override
    public String toString() {
        return AnsiCodes.ANSI_YELLOW + getImDbRatingStars() + AnsiCodes.ANSI_RESET + '\n' +
                AnsiCodes.ANSI_GRAY + "Titulo: '" + AnsiCodes.ANSI_RESET + fullTitle + '\n' +
                AnsiCodes.ANSI_GRAY + "Poster: '" + AnsiCodes.ANSI_RESET + image + '\n';
    }
}

