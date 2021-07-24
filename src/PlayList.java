import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class PlayList implements Listenable{

    final private String aName;
    final private List<Song> aSongs = new ArrayList<>();
    private Time aLength;

    public PlayList(String name) {
        this.aName = name;
    }


    @Override
    public void play() {

    }

    @Override
    public void restart() {

    }
}
