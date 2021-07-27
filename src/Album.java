import java.awt.*;
import java.util.Objects;

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
        return "Album{" +
                "Artist=" + aArtist +
                ", Year=" + aYear +
                ", Cover Image=" + aCover +
                ", Title='" + aTitle + '\'' +
                '}';
    }
}
