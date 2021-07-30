/**
 * The abstract Element to be visited by the Visitor.
 * Part of the Visitor Design Pattern.
 */
public interface ToBeVisited {
    /**
     * This method allows certain computations (visitors) to be done on a SongList or a Song.
     * @param v
     *         a particular computation.
     */
    void acceptVisitor(Visitor v);
}