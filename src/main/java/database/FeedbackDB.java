package database;

import basic.LoggerUtility;
import entity.FeedBack;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FeedbackDB {
    private static final Logger LOGGER = LoggerUtility.getLogger();

    static List<FeedBack> feedBacks= new ArrayList<>();
    private FeedbackDB() {
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
        LOGGER.info("Your feedback has been submitted successfully");
    }


    public static List<FeedBack> getFeedback() {
        return feedBacks;
    }
}
