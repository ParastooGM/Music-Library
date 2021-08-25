import javafx.scene.image.Image;
import java.util.*;
import java.util.List;

/**
 * An Artist Object has Songs and Albums.
 */
public class Artist {

    final private String aName;
    final private List<Song> aSongs = new ArrayList<>();
    final private List<Album> aDiscography = new ArrayList<>();
    private Optional<javafx.scene.image.Image> aProfilePicture = Optional.empty();

    /**
     * constructor of the Artist class.
     * @param pName name of the artist.
     * @pre pName !=null
     */
    public Artist(String pName) {
        assert pName != null;
        this.aName = pName;
    }


    //Getter methods
    /**
     * @return the name of the Artist.
     */
    public String getName(){
        return aName;
    }


    /**
     * @return the profile image of the artist.
     * @throws IllegalStateException if the artist does not have any profile pictures set yet.
     */
    public javafx.scene.image.Image getProfilePicture() throws IllegalStateException{
        if (aProfilePicture.isPresent()){
            return aProfilePicture.get();
        }else{
            throw new IllegalStateException("No Profile Picture has been set for this artist yet.");
        }
    }

    /**
     * Changes the profile picture of the artist.
     * @param pImage the new profile image.
     * @pre pImage != null;
     */
    public void changeProfilePicture(Image pImage){
        assert pImage != null;
        aProfilePicture = Optional.of(pImage);
    }

    /**
     * @return a list iterator on all the available albums of the artist in the music library.
     */
    public Iterator<Album> getAlbums() {
        return Collections.unmodifiableList(aDiscography).listIterator();
    }

    /**
     * @return a list of the available albums of the artist in the music library.
     */
    public List<Album> getAlbumsList() {
        return Collections.unmodifiableList(aDiscography);
    }


    /**
     * @return a list iterator on all the available songs of the artist in the music library.
     */
    public Iterator<Song> getSongs() {
        return Collections.unmodifiableList(aSongs).listIterator();
    }

    //Other class methods
    /**
     * Adds an album to the artist's discography.
     * @param pAlbum the album to be added.
     * @pre pAlbum != null;
     * @throws IllegalArgumentException if pAlbum has a different artist than the current artist.
     */
    public void addAlbum(Album pAlbum){
        assert pAlbum != null;
        if (pAlbum.getArtist() == this){
            aDiscography.add(pAlbum);
        }else{
            throw new IllegalArgumentException(pAlbum + " belongs to " + pAlbum.getArtist() + ", not " + this + "!");
        }

    }

    /**
     * Removes an album from the artist's discography.
     * @param pAlbum the album to be removed.
     * @pre pAlbum != null
     */
    public void removeAlbum(Album pAlbum){
        assert pAlbum != null;
        aDiscography.remove(pAlbum);
    }

    /**
     * Adds a song to the artists songs list.
     * @param pSong the song to be added.
     * @pre pSong != null;
     * @throws IllegalArgumentException if pSong has a different artist than the current artist.
     */
    public void addSong(Song pSong){
        assert pSong != null;
        if (pSong.getArtist() == this || pSong.getCollabs().contains(this)){
            aSongs.add(pSong);
        }else{
            throw new IllegalArgumentException(pSong + " belongs to " + pSong.getArtist() + ", not " + this + "!");
        }

    }

    /**
     * Removes a song from the artist's song list.
     * @param pSong the song to be removed.
     * @pre pSong != null;
     */
    public void removeSong(Song pSong){
        assert pSong != null;
        aSongs.remove(pSong);
    }



    //Overridden methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return aName.equals(artist.aName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aName);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "aName='" + aName + '\'' +
                '}';
    }
}
