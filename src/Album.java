import java.awt.*;

public class Album extends SongList {

    final private Artist aArtist;
    final private int aYear;
    final private String aLanguage;
    final private String aStudio;
    final private Image aCover;


    public Album(Artist aArtist, String aTitle, int aYear, String aLanguage, String aStudio, Image cover) {
        super(aTitle);
        this.aArtist = aArtist;
        this.aYear = aYear;
        this.aLanguage = aLanguage;
        this.aStudio = aStudio;
        this.aCover = cover;
    }

    public Artist getaArtist() {
        return aArtist;
    }

    public int getaYear() {
        return aYear;
    }

    public String getaLanguage() {
        return aLanguage;
    }

    public String getaStudio() {
        return aStudio;
    }

    public Image getaCover() {
        return aCover;
    }

}
