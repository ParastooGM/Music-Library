import javafx.scene.image.Image;
import java.util.Iterator;
import java.util.Objects;

/**
 * An Album object is an aggregation of song Objects.
 * Extends the songList Abstract class.
 */
public class Album extends SongList {

    final private Artist aArtist;
    final private int aYear;
    final private String aLanguage;
    final private String aStudio;
    final private Image aCover;


    //Constructor
    public Album(Artist aArtist, String aTitle, int aYear, String aLanguage, String aStudio, Image cover) {
        super(aTitle);
        assert aArtist != null & cover != null & aLanguage != null & aStudio != null;

        this.aArtist = aArtist;
        this.aYear = aYear;
        this.aLanguage = aLanguage;
        this.aStudio = aStudio;
        this.aCover = cover;
    }

    //Getter methods
    /**
     * @return the artist of the album.
     */
    public Artist getArtist() {
        return aArtist;
    }

    /**
     * @return the year the album was released.
     */
    public int getYear() {
        return aYear;
    }

    /**
     * @return the main language of the album.
     */
    public String getLanguage() {
        return aLanguage;
    }

    /**
     * @return the studio that produced the album.
     */
    public String getStudio() {
        return aStudio;
    }

    /**
     * @return the cover image of the album.
     */
    public Image getCover() {
        return aCover;
    }


    //Other Class Methods
    /**
     * adds this Album to a playlist.
     * @param pPlaylist the playlist to add the album to.
     * @pre pPlayList != null
     */
    public void addToPlayList(PlayList pPlaylist){
        assert pPlaylist != null;
        Iterator<Song> iterator = getSongs();
        while (iterator.hasNext()){
            pPlaylist.addSong(iterator.next());
        }
    }


    //Overridden methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Album album = (Album) o;
        return aYear == album.aYear && aArtist.equals(album.aArtist) && aLanguage.equals(album.aLanguage) && aStudio.equals(album.aStudio) && aCover.equals(album.aCover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), aArtist, aYear, aLanguage, aStudio, aCover);
    }

    @Override
    public String toString() {
        return  aTitle + " {" +
                "Artist=" + aArtist.getName() +
                ", Year=" + aYear +
                '}';
    }
}
