import java.util.Objects;

public class NowPlayingObserver implements Observer{

    private final String aName;

    public NowPlayingObserver(String name){
        aName = name;
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
            System.out.println("Now Playing " + aSong.getTitle() + " by " + aSong.getArtist() + ", and " + aSong.getCollabs());
        }else{
            System.out.println("Now Playing " + aSong.getTitle() + " by " + aSong.getArtist());
        }

    }
}
