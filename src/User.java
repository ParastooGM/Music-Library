import java.util.*;

public class User {

    final private String name;
    final private PlayList favorites = new PlayList("Favorites");
    final private Map<String, PlayList> playLists = new HashMap<>();

    /**
     * Constructor.
     * @param name the name of user.
     */
    public User(String name) {
        assert name!= null;
        this.name = name;
    }

    /**
     * @return name of the user.
     */
    public String getName(){
        return name;
    }

    /**
     * Adds a song to the favorites PlayList. If the song already exists in the playlist, nothing happens.
     * @param pSong the song to be added to the favorites.
     * @pre pSong != null
     */
    public void addToFavorites(Song pSong){
        assert pSong != null;

       Iterator<Song> iter = favorites.getSongs();
       while(iter.hasNext()){
           if (iter.next() == pSong){
               return;
           }
       }
            favorites.addSong(pSong);
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
        playLists.put(playList.getTitle(), playList);
   }

    /**
     * creates a playlist with the input title and adds it to the Users's playlists.
     * @param aName the name of the new playlist.
     * @pre aName != null;
     * @throws IllegalStateException if a playlist with the same name already exists in the library.
     */
   public void createAndAddPlayList(String aName){
        assert aName != null;
        PlayList newPlayList = new PlayList(aName);
        if (playLists.get(name) != null){
            throw new IllegalArgumentException("A playList with the same name already exists in the library.");
        }else{
            playLists.put(newPlayList.getTitle(), newPlayList);
        }

   }

    /**
     * @return an iterator on the user's playlists.
     */
   public Iterator<PlayList> getPlayLists(){
       return playLists.values().iterator();
   }

    /**
     * @return a list of playlists
     */
   public List<PlayList> getPlayListsList(){
       List l = new ArrayList();
       for (PlayList pl : playLists.values()){
           l.add(pl);
       }
       return Collections.unmodifiableList(l);
   }

    /**
     * @return  the favorites play list.
     */
   public PlayList getFavorites(){
       return favorites;
   }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name +
                '}';
    }
}
