import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A concrete visitor to calculate the total number of artists.
 */
public class TotalArtistsVisitor extends AbstractVisitor{

    private final Set<Artist> artists = new HashSet<>();

    /**
     * Calculates the total number of artists in a Song.
     * @param aSong Song to be visited.
     * @pre aSong != null
     */
    @Override
    public void VisitSong(Song aSong){
        assert aSong != null;
        artists.add(aSong.getArtist());
        if (aSong.getCollabs().size() != 0){
            for (Artist a : aSong.getCollabs()){
                artists.add(a);
            }
        }

    }


    /***
     * @return the calculated results, i.e. the total number of artists.
     */
    public Set<Artist> getTotalArtists(){
        return (Set<Artist>) Collections.unmodifiableSet(artists);
    }




}
