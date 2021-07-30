/**
 * The Abstract Visitor Interface in the Visitor Design Pattern.
 */
public interface Visitor {

    /**
     * Callback to a concrete visitor to visit a SongList.
     *
     * @param aSongList SongList to be visited.
     */
    void VisitSongList(SongList aSongList);

    /**
     * Callback to a concrete visitor to visit a Song.
     *
     * @param aSong Song to be visited.
     */
    void VisitSong(Song aSong);
}