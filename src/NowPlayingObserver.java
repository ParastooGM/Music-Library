import java.util.Objects;

/**
 * A concrete Observer which keeps track of the currently playing song.
 */
public class NowPlayingObserver implements Observer{

    private final String aName;
    private String msg = "";

    //Constructor
    public NowPlayingObserver(String name){
        assert name != null;
        aName = name;
    }

    //Getter methods
    /**
     * @return the message of the observer, i.e. the song that is currently playing.
     */
    public String getMsg(){
        return msg;
    }

    //Interface Overridden methods
    @Override
    public String getName() {
        return aName;
    }

    /**
     * Overriding noticed() from the Observer Interface.
     * @param aSong the song that is being observed, i.e. currently playing.
     * @pre aSong != null;
     */
    @Override
    public void noticed(Song aSong) {
        assert aSong != null;
        try{
            msg =  "Now Playing " + aSong.getTitle() + " by " + aSong.getArtist() + ", and " + aSong.getCollabs();
        }catch(IllegalStateException e){
            msg =  "Now Playing " + aSong.getTitle() + " by " + aSong.getArtist();
        }

    }

    //Other Overridden methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NowPlayingObserver that = (NowPlayingObserver) o;
        return aName.equals(that.aName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aName);
    }


}
