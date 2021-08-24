import java.util.Iterator;

public class TestTotalLengthVisitor implements Visitor{

    private long totalLength = 0;


    /**
     * @return the total length calculated by the visitor.
     */
    public long getTotalLength(){
        return totalLength;
    }


    /**
     * Callback to TotalLength concrete visitor to visit a SongList and calculate its length.
     * @param aSongList SongList to be visited.
     */
    @Override
    public void VisitSongList(SongList aSongList) {
        assert aSongList != null;

        Iterator<Song> iterator = aSongList.getSongs();
        while(iterator.hasNext()){
            totalLength += iterator.next().getLength();
        }
    }

    /**
     *  Callback to TotalLength concrete visitor to visit a Song and calculate its length.
     * @param aSong Song to be visited.
     */
    @Override
    public void VisitSong(Song aSong) {
        assert aSong != null;
        totalLength += aSong.getLength();
    }
}
