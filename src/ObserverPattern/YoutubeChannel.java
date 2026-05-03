package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject{

    private List<Observer> subscribers = new ArrayList<>();
    private State state ;
    private String name ;

    public YoutubeChannel(  String name) {
        this.name = name;
    }

    public List<Observer> getSubscribers() {
        return subscribers;
    }

    public State getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }


    public void uploadVideo() {
        this.state = State.New_video_uploaded;
        notifyObservers();
    }

    public void startLive() {
        this.state = State.Live_Started;
        notifyObservers();
    }


    @Override
    public void notifyObservers() {
        subscribers.forEach(s->{
            s.update(state);
        });
    }

}
