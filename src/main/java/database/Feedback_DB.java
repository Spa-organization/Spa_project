package database;

import Entities.Client;
import Entities.FeedBack;

import java.util.ArrayList;
import java.util.List;

public class Feedback_DB {

    static List<FeedBack> feedBacks= new ArrayList<FeedBack>();
    private Feedback_DB() {
        throw new IllegalStateException("Utility class");
    }
    static{
        feedBacks.add(new FeedBack("Amazing"));
        feedBacks.add(new FeedBack("The service is awesome"));
        feedBacks.add(new FeedBack("Nice work"));
        feedBacks.add(new FeedBack("Perfect staff"));
    }
    public static void addFeedback(String feed) {

        feedBacks.add(new FeedBack(feed));
    }
    public static void call()
    {
        new Feedback_DB();
    }

    public static List<FeedBack> getFeedback() {
        return feedBacks;
    }
}
