package ObserverPattern;

import java.util.List;

public interface Subject {

    void subscribe (Observer observer);
    void unsubscribe (Observer observer);
    void notifyObservers();

}
