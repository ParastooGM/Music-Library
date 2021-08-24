import java.util.Objects;

public class NowPlayingObserver implements Observer{

    private final String aName;
    private String msg = "";

    public NowPlayingObserver(String name){
        aName = name;
    }

    /**
     * @return the message of the observer, i.e. the song that is currently playing.
     */
    public String getMsg(){
        return msg;
    }

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

    /**
     * Overriding noticed() from the Observer Interface.
     * @param aSong the song that is being observed, i.e. currently playing.
     * @pre aSong != null;
     */
    @Override
    public void noticed(Song aSong) {
        assert aSong != null;
        if(aSong.getCollabs().size() != 0){
            msg =  "Now Playing " + aSong.getTitle() + " by " + aSong.getArtist() + ", and " + aSong.getCollabs();
        }else{
            msg =  "Now Playing " + aSong.getTitle() + " by " + aSong.getArtist();
        }

    }

    @Override
    public String getName() {
        return aName;
    }
}
