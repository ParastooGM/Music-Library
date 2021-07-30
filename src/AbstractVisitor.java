import java.util.Iterator;

/**
 * Abstract visitor to be an adapter class and to pull up common traversals between all visitors.
 */
public abstract class AbstractVisitor implements Visitor{

    /**
     * Implements VisitSongList from the Visitor Interface.
     * To visit a SongList, all its Songs must be visited.
     * @param aSongList
     *          SongList to be visited.
     * @pre aSongList != null
     */
    public void VisitSongList(SongList aSongList){
        assert aSongList != null;
        Iterator iter = aSongList.getSongs();
        while(iter.hasNext()){
            ((Song) iter.next()).acceptVisitor(this);
        }
    };

    /**
     * A placeholder for the VisitSongList method from the Visitor interface.
     * @param aSong Song to be visited.
     */
    @Override
    public void VisitSong(Song aSong){};
}
