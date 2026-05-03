package ObserverPattern;

public class Subscriber implements Observer{
    String name ;
    String subscribedDate ;

    public Subscriber(String name, String subscribedDate) {
        this.name = name;
        this.subscribedDate = subscribedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubscribedDate() {
        return subscribedDate;
    }

    public void setSubscribedDate(String subscribedDate) {
        this.subscribedDate = subscribedDate;
    }

    @Override
    public void update(State state) {
        System.out.println("Subscriber "+this.name+" notified about: " + state);
    }
}
