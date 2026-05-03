package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject_A implements Subject{
    private final List <Observer> observers = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update());
    }

}
