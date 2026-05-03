package ObserverPattern;

public class ConcreteObserver_A implements Observer {
    @Override
    public void update() {
        System.out.println("Observer A Updated .. ");
    }
}
