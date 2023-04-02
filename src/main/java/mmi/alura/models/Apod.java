package mmi.alura.models;

import com.google.gson.Gson;
import mmi.alura.utils.AnsiCodes;
import mmi.alura.utils.Requester;

import java.util.Date;

public class Apod implements Content{
    public Date date;
    public String explanation;
    public String hdurl;
    public String media_type;
    public String service_version;
    public String title;
    public String url;

    public String getImageUrl() {
        return url;
    }
    @Override
    public String toString() {
        return AnsiCodes.ANSI_GRAY + "Data: '" + AnsiCodes.ANSI_RESET + date + '\n' +
                AnsiCodes.ANSI_GRAY + "Titulo: '" + AnsiCodes.ANSI_RESET + title + '\n' +
                AnsiCodes.ANSI_GRAY + "Imagem: '" + AnsiCodes.ANSI_RESET + url + '\n';
    }
}
