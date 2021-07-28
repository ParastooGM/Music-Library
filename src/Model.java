/**
 The Model used in the Observer Design Pattern.*/
public interface Model {

    /**
     * Adds [a new] pObserver to the Model.
     * @param pObserver
     */
    void acceptObserver(Observer pObserver);

    /**
     * Removes pObserver from the Model.
     * @param pObserver
     */
    void removeObserver(Observer pObserver);


}

