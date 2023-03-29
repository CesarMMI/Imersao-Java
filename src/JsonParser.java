import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_PROPERTIES = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Filme> parse(String response) {
        Matcher matcher = REGEX_ITEMS.matcher(response);
        if (!matcher.find())
            throw new IllegalArgumentException("Não encontrou items.");

        String[] items = matcher.group(1).split("\\},\\{");
        List<Filme> list = new ArrayList<>();

        for (String item : items)
            list.add(getFilme(item));
        return list;
    }

    private Filme getFilme(String item){
        Filme filme = new Filme();
        Matcher matcherProperties = REGEX_PROPERTIES.matcher(item);
        while (matcherProperties.find()) {
            String field = matcherProperties.group(1);
            String value = matcherProperties.group(2);
            switch (field){
                case "id":
                    filme.setId(value);
                    break;
                case "rank":
                    filme.setRank(Integer.parseInt(value));
                    break;
                case "title":
                    filme.setTitle(value);
                    break;
                case "fullTitle":
                    filme.setFullTitle(value);
                    break;
                case "year":
                    filme.setYear(value);
                    break;
                case "image":
                    filme.setImage(value);
                    break;
                case "crew":
                    filme.setCrew(value);
                    break;
                case "imDbRating":
                    filme.setImDbRating(Double.parseDouble(value));
                    break;
                case "imDbRatingCount":
                    filme.setImDbRatingCount(Long.parseLong(value));
                    break;
            }
        }
        return filme;
    }

}