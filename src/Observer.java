
/**
 * The Observer used in the Observer Design Pattern
 */
public interface Observer {

    /**
     * This method is called when an observer needs to be notified.
     * It is the callback method in the Observer Design Pattern.
     * @param aSong
     *          The current song being played.
     */
    void noticed(Song aSong);

    String getName();
}
