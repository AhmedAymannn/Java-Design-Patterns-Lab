package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {


            Subscriber s1 = new Subscriber("Ahmed" , "may 3 2021");
            Subscriber s2 = new Subscriber("Sara" ,  "Dec 24 2014");
            Subscriber s3 = new Subscriber("Mohamed" , "jan 15 2022");
            Subscriber s4 = new Subscriber("Fatima" ,  "mar 10 2020");
            Subscriber s5 = new Subscriber("Omar" ,  "june 3 2003");
            
            YoutubeChannel channel_1= new YoutubeChannel( "Channel_1");
            
            // Subscribe users to the channel
            channel_1.subscribe(s1);
            channel_1.subscribe(s2);
            channel_1.subscribe(s3);
            channel_1.subscribe(s4);
            channel_1.subscribe(s5);
            
            System.out.println("=== Channel 1 Uploads a New Video ===");
            channel_1.uploadVideo();
            
            System.out.println("\n=== Channel 1 Starts a Live Stream ===");
            channel_1.startLive();
            
            // Unsubscribe one user
            System.out.println("\n=== " + s5.getName() + " Unsubscribes ===");
            channel_1.unsubscribe(s5);
            
            System.out.println("\n=== Channel 1 Uploads Another Video ===");
            channel_1.uploadVideo();
            
        }
}
