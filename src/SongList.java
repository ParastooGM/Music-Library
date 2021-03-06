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

    //Getter methods
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
     * @return a list of the songs of the songList.
     */
    public List<Song> getSongList(){
        return Collections.unmodifiableList(aSongs);
    }

    /**
     * @return the current song in the songList.
     */
    public Song getCurrentSong(){
        return aSongs.get(currentSongNum);
    }

    /**
     * @return the next song in the songList.
     * Will restart from the beginning of the list.
     */
    public Song getNextSong(){
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
    public Song getPreviousSong() throws IllegalStateException{
        if (currentSongNum == 0 ){
            throw new IllegalStateException("This is the first song in the list.");
        }
        currentSongNum--;
        return aSongs.get(currentSongNum);
    }

    //Other Class Methods
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

    //Interface overridden methods

    /**
     * Method from the Listenable interface.
     * Plays all the songs in the SongList in order.
     */
    @Override
    public void play() {
        for (Song s : aSongs){
            s.play();

            if (s.getAudioFormat() == AUDIO_FORMAT.MP3){
                while (true){
                    if (s.getMediaPlayer().getCurrentTime() == s.getMediaPlayer().getStopTime()){
                        s.stop();
                        break;
                    }
                }
            }else{
                while (true){
                    if(s.getClip().getFramePosition() == s.getClip().getFrameLength()){
                        s.stop();
                        break;
                    }
                }
            }
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
            if (aSongs.get(i).getAudioFormat() == AUDIO_FORMAT.MP3){
                while (aSongs.get(i).getMediaPlayer().getCurrentTime() != aSongs.get(i).getMediaPlayer().getStopTime()){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                while (aSongs.get(i).getClip().getFramePosition() != aSongs.get(i).getClip().getFrameLength()){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
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

    //Other overridden methods.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongList songList = (SongList) o;
        return aTitle.equals(songList.aTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aTitle);
    }
}
