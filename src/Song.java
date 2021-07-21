import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Song {

    final private File aPath;
    final private Artist aArtist;
    final private String aTitle;
    final private int aYear;
    final private String aLanguage;
    final private String aStudio;
    final private List<Artist> aColabs = new ArrayList<>();

    public Song(File path, Artist aArtist, String aTitle, int aYear, String aLanguage, String aStudio) {
        this.aPath = path;
        this.aArtist = aArtist;
        this.aTitle = aTitle;
        this.aYear = aYear;
        this.aLanguage = aLanguage;
        this.aStudio = aStudio;
    }
}
