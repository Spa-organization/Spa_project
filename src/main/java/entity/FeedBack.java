package entity;

public class FeedBack {
    private String feed;
    private int clientId;


    public FeedBack(String feed,int clientId){
        this.clientId=clientId;
        this.feed=feed;

    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getFeed() {
        return feed;
    }

    public int getClientId() {
        return clientId;
    }
}
