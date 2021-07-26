import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class SongList implements Listenable {

    protected String aTitle;
    final protected List<Song> aSongs = new ArrayList<>();
    protected int numSongs = 0;
    private int aNextToListen;
    private long aLength;

    /**
     * protected constructor to be used in classes that extend SongList.
     * @param pTitle the title of the SongList.
     * @pre pTitle != null
     */
    protected SongList(String pTitle) {
        assert pTitle != null;
        this.aTitle = pTitle;
    }

    /**
     * Adds a Song to the SongList without duplicates. This is also
     * where the numSongs variable gets updated.
     * @param pSong the Song to be added
     * @pre pSong != null
     */
    public void addSong(Song pSong){
            assert pSong != null;
            if (! aSongs.contains(pSong)) {
                aSongs.add(pSong);
                numSongs++;
                aLength += pSong.getLength();
            }
      }

    /**
     * @return the title of the SongList.
     */
    public String getTitle() {
        return aTitle;
    }

    /**
     * @return an unmodifiable iterator on the songs in the songList.
     */
    public Iterator<Song> getSongs() {
        return Collections.unmodifiableList(aSongs).listIterator();
    }

    /**
     * @return the number of songs in the songsList.
     */
    public int getNumSongs() {
        return numSongs;
    }


    public int getNextToListen() {
        return aNextToListen;
    }

    /**
     * @return the total duration of the SongList.
     */
    public long getLength() {
        return aLength;
    }

    public void shufflePlay(){

    };

    public void NextSong(){

    };


    public void PreviousSong(){

    };

    @Override
    public void play() {

    }

    @Override
    public void restart() {

    }


}
