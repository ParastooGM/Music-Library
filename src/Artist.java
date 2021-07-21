import java.util.ArrayList;
import java.util.List;

public class Artist {

    final private String aName;
    final private List<Song> aSongs = new ArrayList<>();
    final private List<Album> aDiscography = new ArrayList<>();

    public Artist(String aName) {
        this.aName = aName;
    }
}
