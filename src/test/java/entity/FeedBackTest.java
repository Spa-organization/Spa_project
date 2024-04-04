package entity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FeedBackTest {

    @Test
    public void testFeedBack()
    {
        FeedBack feedBack = new FeedBack("test", 1);
        feedBack.getFeed();
        feedBack.getClientId();
        feedBack.setFeed("new");
        assertTrue(true);
    }

}