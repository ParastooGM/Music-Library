import java.util.*;

public abstract class SongList implements Listenable, ToBeVisited {

    protected String aTitle;
    final protected List<Song> aSongs = new ArrayList<>();
    protected int numSongs = 0;
    private int currentSongNum =0;
    protected long aLength;

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
     * where the numSongs variable and aLength Variable get updated.
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

    /**
     * @return the total duration of the SongList.
     */
    public long getLength() {
        return aLength;
    }

    /**
     * Plays the songs on the songList in a random order.
     */
    public void shufflePlay(){
        List<Song> temp = new ArrayList<>(aSongs);
        while (temp.size() != 0){
            int rand =  new Random().nextInt(temp.size());
            temp.get(rand).play();
            currentSongNum = aSongs.indexOf(temp.get(rand));
            temp.remove(rand);
        }

    }

    /**
     * @return the current song in the songList.
     */
    public Song currentSong(){
        return aSongs.get(currentSongNum);
    }

    /**
     * @return the next song in the songList.
     * Will restart from the beginning of the list.
     */
    public Song NextSong(){
        if (currentSongNum == aSongs.size() -1){
            currentSongNum = -1;
        }
        currentSongNum++;
        return aSongs.get(currentSongNum);
    }


    /**
     * @return the previous song on the SongList
     * @throws IllegalStateException when the current song is the first song in the list.
     */
    public Song PreviousSong() throws IllegalStateException{
        if (currentSongNum == 0 ){
            throw new IllegalStateException("This is the first song in the list.");
        }
        currentSongNum--;
        return aSongs.get(currentSongNum);
    }

    /**
     * Method from the Listenable interface.
     * Plays all the songs in the SongList in order.
     */
    @Override
    public void play() {
        for (Song s : aSongs){
            s.play();
            currentSongNum++;

        }
    }

    /**
     * restarts the SongList by setting the current song to the first song in the list.
     */
    @Override
    public void restart() {
        currentSongNum = 0;
        play();
    }

    @Override
    public void stop(){
        aSongs.get(currentSongNum).stop();
    }

    @Override
    public void pause(){
        aSongs.get(currentSongNum).pause();
    }

    @Override
    public void resumeAudio(){
        aSongs.get(currentSongNum).resumeAudio();
        for (int i = currentSongNum++; i< numSongs; i++ ){
            aSongs.get(i).play();
            currentSongNum++;
        }
    }


    /**
     * Implementing the acceptVisitor method from ToBeVisited interface.
     * @param v a particular visitor on the SongList.
     * @pre v != null
     */
    @Override
    public void acceptVisitor(Visitor v){
        assert v != null;
        v.VisitSongList(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongList songList = (SongList) o;
        return aTitle.equals(songList.aTitle) && aSongs.equals(songList.aSongs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aTitle, aSongs);
    }
}
