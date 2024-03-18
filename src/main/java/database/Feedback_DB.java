package database;

import Entities.FeedBack;

import java.util.ArrayList;
import java.util.List;

public class Feedback_DB {

    static List<FeedBack> feedBacks= new ArrayList<FeedBack>();
    private Feedback_DB() {
        throw new IllegalStateException("Utility class");
    }
    static{
        feedBacks.add(new FeedBack("Amazing",11));
        feedBacks.add(new FeedBack("The service is awesome",12));
        feedBacks.add(new FeedBack("Nice work",13));
        feedBacks.add(new FeedBack("Perfect staff",14));
    }
    public static void addFeedback(String feed , int clientId) {

        feedBacks.add(new FeedBack(feed,clientId));
        System.out.println("Your feedback has been submitted successfully");
    }


    public static List<FeedBack> getFeedback() {
        return feedBacks;
    }
}
