import java.awt.*;
import java.util.*;
import java.util.List;

public class Artist {

    final private String aName;
    final private List<Song> aSongs = new ArrayList<>();
    final private List<Album> aDiscography = new ArrayList<>();
    private Optional<Image> aProfilePicture = Optional.empty();

    /**
     * constructor of the Artist class.
     * @param pName
     * @pre pName !=null
     */
    public Artist(String pName) {
        assert pName != null;
        this.aName = pName;
    }

    /**
     * @return the profile image of the artist.
     * @throws IllegalStateException if the artist does not have any profile pictures set yet.
     */
    public Image getProfilePicture() throws IllegalStateException{
        if (aProfilePicture.isPresent()){
            return aProfilePicture.get();
        }else{
            throw new IllegalStateException("No Profile Picture has been set for this artist yet.");
        }
    };

    public void changeProfilePicture(Image pImage){

    }
    /**
     * @return a list iterator on all the available albums of the artist in the music library.
     */
    public Iterator<Album> getAlbums() {
        return Collections.unmodifiableList(aDiscography).listIterator();
    }

    /**
     * @return a list iterator on all the available songs of the artist in the music library.
     */
    public Iterator<Song> getSongs() {
        return Collections.unmodifiableList(aSongs).listIterator();
    }

    public void addAlbum(Album pAlbum){

    }

    public void removeAlbum(Album pAlbum){

    }
    public void addSong(Song pSong){

    }

    public void removeSong(Song pSong){

    }

    public String getName(){
        return aName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return aName.equals(artist.aName) && aDiscography.equals(artist.aDiscography);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aName, aDiscography);
    }
}
