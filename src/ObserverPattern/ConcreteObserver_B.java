package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class ConcreteObserver_B implements Observer{

    @Override
    public void update() {
        System.out.println("Observer B Updated .. ");
    }
}
