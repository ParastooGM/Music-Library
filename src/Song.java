import java.io.File;
import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Song implements Listenable{

    final private File aPath;
    final private Artist aArtist;
    final private String aTitle;
    final private int aYear;
    final private String aLanguage;
    final private String aStudio;
    final private long alength;
    final private Optional <List<Artist>> aCollabs = Optional.empty();

    public Song(File path, Artist aArtist, String aTitle, int aYear, String aLanguage, String aStudio, long alength) {
        assert path.exists() && aArtist!= null;

        this.alength = alength;
        this.aPath = path;
        this.aArtist = aArtist;
        this.aTitle = aTitle;
        this.aYear = aYear;
        this.aLanguage = aLanguage;
        this.aStudio = aStudio;
    }

    /**
     * adds a collaborating artist to the song.
     * @param pArtist the collaborating artist to be added on the song.
     * @pre pArtist != null; pArtist != aArtist;
     */
    public void addCollab(Artist pArtist){
        assert pArtist != null;
        assert pArtist != aArtist;

        if (!aCollabs.get().contains(pArtist)){
            aCollabs.get().add(pArtist);
        }
    };

    public List<Artist> getCollabs() throws IllegalStateException{
        if (aCollabs.isPresent()){
            return aCollabs.get();
        }else{
            throw new IllegalStateException("This song has not collaborating artists.");
        }
    }

    public Artist getArtist() {
        return aArtist;
    }

    public String getTitle() {
        return aTitle;
    }

    public int getYear() {
        return aYear;
    }

    public String getLanguage() {
        return aLanguage;
    }

    public long getLength(){
        return alength;
    }

    public String getStudio() {
        return aStudio;
    }

    public File getPath() {
        return aPath;
    }

    @Override
    public void play() {

    }

    @Override
    public void restart() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return aYear == song.aYear && aArtist.equals(song.aArtist) && aTitle.equals(song.aTitle) && aLanguage.equals(song.aLanguage) && aCollabs.equals(song.aCollabs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aArtist, aTitle, aYear, aLanguage, aCollabs);
    }
}
