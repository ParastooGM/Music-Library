import java.util.Iterator;

/**
 * A Playlist object is an aggregation of song Objects.
 * Extends the songList Abstract class.
 */
public class PlayList extends SongList{

    //Constructor
    public PlayList(String aTitle) {
        super(aTitle);
    }


    //Class methods
    /**
     * Renames a playlist after its creation.
     * @param aName the new name of the playlist.
     * @pre aName != null
     */
    public void rename(String aName){
        assert aName !=null;
        aTitle = aName;
    }

    /**
     * Adds a whole album (all of its songs one by one) to a playlist.
     * @param album the album to be added.
     */
    public void addAlbum (Album album){
        Iterator<Song> iter = album.getSongs();
        while (iter.hasNext()){
            Song s = iter.next();
            if (!aSongs.contains(s)){
                addSong(s);
            }

        }
    }

    /**
     * Removes a song from the playlist.\, updates the number of songs and the duration of the playlist.
     * @param pSong the song to be removed.
     * @pre pSong != null
     */
    public void removeSong(Song pSong){
        assert pSong != null;
        if (aSongs.contains(pSong)) {
            aSongs.remove(pSong);
            numSongs--;
            aLength -= pSong.getLength();
        }
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "Title='" + aTitle + '\'' +
                ", number of songs=" + numSongs +
                '}';
    }
}
