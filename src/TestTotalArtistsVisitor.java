import java.util.*;

public class TestTotalArtistsVisitor implements Visitor{

    final private Set<String> totalArtists = new HashSet<>();

    public Set<String> getTotalArtists(){
        return Collections.unmodifiableSet(totalArtists);
    }

    /**
     *  Callback to TotalLength concrete visitor to visit a SongList and get all its artists.
     * @param aSongList SongList to be visited.
     */
    @Override
    public void VisitSongList(SongList aSongList) {
        assert aSongList != null;

        Iterator<Song> iterator = aSongList.getSongs();
        while(iterator.hasNext()){
            Song s = iterator.next();
            totalArtists.add(s.getArtist().getName());
            for (Artist a : s.getCollabs()){
                totalArtists.add(a.getName());
            }
        }
    }

    /**
     *  Callback to TotalArtist concrete visitor to visit a Song and get all its artists.
     * @param aSong Song to be visited.
     */
    @Override
    public void VisitSong(Song aSong) {
        assert aSong != null;
        totalArtists.add(aSong.getArtist().getName());
        for (Artist a : aSong.getCollabs()){
            totalArtists.add(a.getName());
        }

    }
}
