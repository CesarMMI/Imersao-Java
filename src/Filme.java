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
    private List<String> crew;
    private Double imDbRating;
    private Long imDbRatingCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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

    public List<String> getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        List<String> list = new ArrayList<String>(Arrays.asList(crew.split(",")));
        for (int i = 0; i < list.size(); i++)
            list.set(i, list.get(i).trim());
        this.crew = list;
    }

    public Double getImDbRating() {
        return imDbRating;
    }

    public String getImDbRatingStars() {
        String stars = "";
        for (int i = 0; i < Math.floor(imDbRating); i++) {
            stars += "★";
        }
        return stars;
    }

    public void setImDbRating(Double imDbRating) {
        this.imDbRating = imDbRating;
    }

    public Long getImDbRatingCount() {
        return imDbRatingCount;
    }

    public void setImDbRatingCount(Long imDbRatingCount) {
        this.imDbRatingCount = imDbRatingCount;
    }

    @Override
    public String toString() {
        return (
                AnsiCodes.ANSI_YELLOW + getImDbRatingStars() + AnsiCodes.ANSI_RESET +
                AnsiCodes.ANSI_GRAY + "\nTítulo: " + AnsiCodes.ANSI_RESET + getFullTitle() +
                AnsiCodes.ANSI_GRAY + "\nPoster: " + AnsiCodes.ANSI_RESET + getImage());
    }
}

