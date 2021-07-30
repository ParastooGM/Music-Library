
/**
 * A concrete visitor to calculate the total length of a Song/ SongList.
 */
public class TotalLengthVisitor extends AbstractVisitor{

    private long totalLength = 0;

    /**
     * Calculates the total length of a song.
     * @param aSong Song to be visited.
     * @pre aSong != null
     */
    @Override
    public void VisitSong(Song aSong){
        assert aSong != null;
        totalLength += aSong.getLength();
    }

    /**
     * @return the claculated results, i.e. the total length.
     */
    public long getTotalLength(){
        return totalLength;
    }
}
