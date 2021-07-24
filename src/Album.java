import java.util.ArrayList;
import java.util.List;

public class Album implements Listenable{
    final private Artist aArtist;
    final private String aTitle;
    final private int aYear;
    final private String aLanguage;
    final private String aStudio;
    final private List<Song> aSongs = new ArrayList<>();
    private int aNextToListen;


    public Album(Artist aArtist, String aTitle, int aYear, String aLanguage, String aStudio) {
        this.aArtist = aArtist;
        this.aTitle = aTitle;
        this.aYear = aYear;
        this.aLanguage = aLanguage;
        this.aStudio = aStudio;
    }

    @Override
    public void play() {

    }

    @Override
    public void restart() {

    }
}
