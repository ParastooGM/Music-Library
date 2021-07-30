import java.io.File;
import java.util.*;

public class Song implements Listenable , Model, ToBeVisited{

    final private File aPath;
    final private Artist aArtist;
    final private String aTitle;
    final private int aYear;
    final private String aLanguage;
    final private String aStudio;
    final private long aLength;
    final private Optional <List<Artist>> aCollabs = Optional.empty();
    private final Set<Observer> aObservers = new HashSet<>(); //set data structure to store the observers for this model.

    public Song(File path, Artist aArtist, String aTitle, int aYear, String aLanguage, String aStudio, long aLength) {
        assert path.exists() && aArtist!= null;

        this.aLength = aLength;
        this.aPath = path;
        this.aArtist = aArtist;
        this.aTitle = aTitle;
        this.aYear = aYear;
        this.aLanguage = aLanguage;
        this.aStudio = aStudio;
    }

    /**
     * adds a collaborating artist to the song.
     * @param pArtist the collaborating artist to be added on the song.
     * @pre pArtist != null; pArtist != aArtist;
     */
    public void addCollab(Artist pArtist){
        assert pArtist != null;
        assert pArtist != aArtist;

        if (!aCollabs.get().contains(pArtist)){
            aCollabs.get().add(pArtist);
        }
    }

    /**
     * @return collaborating artists of the song.
     * @throws IllegalStateException if there are no collaborating artists in the song.
     */
    public List<Artist> getCollabs() throws IllegalStateException{
        if (aCollabs.isPresent()){
            return aCollabs.get();
        }else{
            throw new IllegalStateException("This song has not collaborating artists.");
        }
    }

    /**
     * @return the artist of the song.
     */
    public Artist getArtist() {
        return aArtist;
    }

    /**
     * @return the title of the song.
     */
    public String getTitle() {
        return aTitle;
    }

    /**
     * @return the year that the song was released.
     */
    public int getYear() {
        return aYear;
    }

    /**
     * @return the main language of the song.
     */
    public String getLanguage() {
        return aLanguage;
    }

    /**
     * @return the length of the song.
     */
    public long getLength(){
        return aLength;
    }

    /**
     * @return the producing studio of the song.
     */
    public String getStudio() {
        return aStudio;
    }

    /**
     * @return the path of the song in the system.
     */
    public File getPath() {
        return aPath;
    }

    /**
     * adds this song to a playlist.
     * @param pPlayList the playlist to add the song to.
     * @pre pPlayList != null
     */
    public void addToPlyList(PlayList pPlayList){
        assert pPlayList != null;
        pPlayList.addSong(this);
    }
    /**
     * Method from the Listenable interface.
     * Plays the audio file of the song.
     */
    @Override
    public void play() {
        //TODO
        //PLAY AUDIO FILE

        NowPlayingObserver observer = new NowPlayingObserver("Observer 1");
        aObservers.add(observer);

        // Notifying the observers. In the current state, the Now Playing Observer is notified
        // to log the current song playing.
        for (Observer obs : aObservers){
            obs.noticed( this);
        }

    }

    /**
     * restarts the song from the beginning.
     */
    @Override
    public void restart() {
        //TODO
        //RESTART AUDIO FILE
    }

    /**
     * Implementing the acceptObserver method from the Model Interface.
     * @param pObserver
     *          Observer to be added to the list of observers for this model.
     * @pre pObserver != null
     */
    @Override
    public void acceptObserver(Observer pObserver) {
        assert pObserver != null;
        aObservers.add(pObserver);
    }

    /**
     * Implementing the removeObserver method from the Model Interface.
     * @param pObserver
     *          Observer to be removed from the list of observers for this model.
     * @pre pObserver != null
     */
    @Override
    public void removeObserver(Observer pObserver){
        aObservers.remove(pObserver);

    }

    /**
     * Implementing the acceptVisitor method from ToBeVisited interface.
     * @param v a particular visitor on the Song.
     * @pre v != null
     */
    @Override
    public void acceptVisitor(Visitor v){
        assert v != null;
        v.VisitSong(this);
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return aYear == song.aYear && aArtist.equals(song.aArtist) && aTitle.equals(song.aTitle) && aLanguage.equals(song.aLanguage) && aCollabs.equals(song.aCollabs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aArtist, aTitle, aYear, aLanguage, aCollabs);
    }

    @Override
    public String toString() {
        return "Song{" +
                " Artist=" + aArtist +
                ", Title='" + aTitle + '\'' +
                ", Year=" + aYear +
                ", Ft=" + aCollabs +
                '}';
    }
}
