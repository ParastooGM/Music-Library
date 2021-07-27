import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class User {

    final private String name;
    final private int age;
    final private List<Song> favorites = new ArrayList<>();
    final private List<PlayList> playLists = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Adds a song to the favorites List.
     * @param pSong the song to be added to the favorites.
     * @pre pSong != null
     */
    public void addToFavorites(Song pSong){
        assert pSong != null;
        if (! favorites.contains(pSong)){
            favorites.add(pSong);
        }

    }

    /**
     * Adds an Album to the favorites List.
     * @param pAlbum the album to be added to the favorites.
     * @pre pAlbum != null
     */
    public void addToFavorites(Album pAlbum){
        assert pAlbum != null;
        Iterator<Song> iter = pAlbum.getSongs();
        while (iter.hasNext()){
            addToFavorites(iter.next());
        }
    }

    /**
     * Adds a playlist to the User's playlists.
     * @param playList the playlist to be added.
     * @pre playList != null
     */
   public void addToMyPlayLists(PlayList playList){
        assert playList != null;
        playLists.add(playList);
   }

    /**
     * creates a playlist with the input title and adds it to the Users's playlists.
     * @param aName the name of the new playlist.
     * @return the newly created playlist.
     */
   public PlayList createPlayList(String aName){
        assert aName != null;
        PlayList newPlaList = new PlayList(aName);
        playLists.add(newPlaList);
        return newPlaList;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
