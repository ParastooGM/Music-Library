import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Song implements Listenable , Model, ToBeVisited{

    final private File aPath;
    final private Artist aArtist;
    final private Album aAlbum;
    final private String aTitle;
    final private int aYear;
    final private String aLanguage;
    final private String aStudio;
    final private long aLength;
    private Optional <List<Artist>> aCollabs = Optional.empty();
    private final Set<Observer> aObservers = new HashSet<>(); //set data structure to store the observers for this model.
    private Long currentFrame; // to store current position
    private Clip clip;
    private String status ="pause"; // current status of clip
    private AudioInputStream audioInputStream;
    private MediaPlayer mediaPlayer;
    private Duration currentTime;

    public Song(File path, Artist aArtist,Album album ,String aTitle, int aYear, String aLanguage, String aStudio, long aLength) {
        assert path.exists() && aArtist!= null && album != null;

        this.aLength = aLength;
        this.aPath = path;
        this.aArtist = aArtist;
        this.aTitle = aTitle;
        this.aYear = aYear;
        this.aLanguage = aLanguage;
        this.aStudio = aStudio;
        this.aAlbum = album;
    }

    /**
     * adds a collaborating artist to the song.
     * @param pArtist the collaborating artist to be added on the song.
     * @pre pArtist != null; pArtist != aArtist;
     */
    public void addCollab(Artist pArtist){
        assert pArtist != null;
        assert pArtist != aArtist;

        if(aCollabs.isEmpty()){
            ArrayList<Artist> newCollabs = new ArrayList<>();
            newCollabs.add(pArtist);
            aCollabs = Optional.of(newCollabs);
        } else if ( !aCollabs.get().contains(pArtist)){
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
     * @return the album of the song.
     */
    public Album getAlbum() {
        return aAlbum;
    }

    /**
     * @return the status of the song : play  or pause.
     */
    public String getSongStatus(){
        return this.status;
    }

    /**
     * @return the observers of the model.
     */
    protected Set<Observer> getObservers(){
        return Collections.unmodifiableSet(aObservers);
    }


    /**
     * Returns the audio format of the song. Songs can only be
     * in a format of mp3 or wav, else a dummy object is returned.
     * @return the audio format of the song
     */
    public AUDIO_FORMAT getAudioFormat(){
        String format = aPath.toString().substring(aPath.toString().length() - 3);
       if (format.equals(AUDIO_FORMAT.WAV.toString())){
            return AUDIO_FORMAT.WAV;
       }else if (format.equals(AUDIO_FORMAT.MP3.toString())){
           return AUDIO_FORMAT.MP3;
       }else{
           return AUDIO_FORMAT.OTHER;
       }
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
        if(getAudioFormat() == AUDIO_FORMAT.WAV){
            try{
                // create AudioInputStream object
                audioInputStream = AudioSystem.getAudioInputStream(this.aPath.getAbsoluteFile());
                // create clip reference
                clip = AudioSystem.getClip();
                // open audioInputStream to the clip
                clip.open(audioInputStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }else if (getAudioFormat() == AUDIO_FORMAT.MP3){
            Media hit = new Media(aPath.toURI().toString());
            mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();

        }else{
            throw new IllegalStateException("Can only play audio files that are either MP3 or WAV.");
        }

        status = "play";
        NowPlayingObserver observer = new NowPlayingObserver(" NowPlayingObserver");
        aObservers.add(observer);

        // Notifying the observers. In the current state, the Now Playing Observer is notified
        // to log the current song playing.
        for (Observer obs : aObservers){
            obs.noticed( this);
        }
    }

    /**
     * Method to pause the audio from the Listenable interface.
     */
    @Override
    public void pause() {
        if (status.equals("pause")) {
            System.out.println("audio is already paused");
            return;
            }
        if (getAudioFormat() == AUDIO_FORMAT.WAV) {
            currentFrame = this.clip.getMicrosecondPosition();
            clip.stop();
        }else if (getAudioFormat() == AUDIO_FORMAT.MP3){
            mediaPlayer.pause();
            currentTime = mediaPlayer.getCurrentTime();
         }else{
            throw new IllegalStateException("Can only play audio files that are either MP3 or WAV.");
        }
        status = "pause";
    }

    /**
     * Method to reset audio stream
     * @throws UnsupportedAudioFileException , IOException , LineUnavailableException
     */

    private void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        audioInputStream = AudioSystem.getAudioInputStream(
                this.aPath.getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    /**
     * restarts the song from the beginning, from the Listenable interface.
     */
    @Override
    public void restart() {
        if (getAudioFormat() == AUDIO_FORMAT.WAV) {
            clip.stop();
            clip.close();
        try {
            resetAudioStream();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
            currentFrame = 0L;
            clip.setMicrosecondPosition(0);
            this.play();
        } else if (getAudioFormat() == AUDIO_FORMAT.MP3){
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();
        }else{
            throw new IllegalStateException("Can only play audio files that are either MP3 or WAV.");
        }
            }

    /**
     * Method to stop the audio from the Listenable interface.
     */
    @Override
    public void stop(){
        if (getAudioFormat() == AUDIO_FORMAT.WAV) {
            currentFrame = 0L;
            clip.stop();
            clip.close();
        }else if (getAudioFormat() == AUDIO_FORMAT.MP3){
            mediaPlayer.stop();
        }else{
            throw new IllegalStateException("Can only play audio files that are either MP3 or WAV.");
        }

    }

    /**
     * Method to resume the audio from the Listenable interface.
     */
    @Override
    public void resumeAudio(){

        if (getAudioFormat() == AUDIO_FORMAT.WAV) {
            if (status.equals("play")) {
                System.out.println("Audio is already being played");
                return;
            }
            clip.close();
            try {
                resetAudioStream();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
                clip.setMicrosecondPosition(currentFrame);
            play();
        } else if (getAudioFormat() == AUDIO_FORMAT.MP3){
            mediaPlayer.seek(currentTime);
        }else{
            throw new IllegalStateException("Can only play audio files that are either MP3 or WAV.");
        }
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
    }

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
        if (aCollabs.isEmpty()){
            return  aTitle + " {" +
                    " Artist=" + aArtist.getName() +
                    ", Year=" + aYear +
                    '}';
        }else{
            return  aTitle + " {" +
                    " Artist=" + aArtist.getName() +
                    ", Year=" + aYear +
                    ", Ft=" + aCollabs.get() +
                    '}';
        }

    }
}
