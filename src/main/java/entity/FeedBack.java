package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class FeedBack {
    @Setter
    private String feed;
    private int clientId;


    public FeedBack(String feed,int clientId){
        this.clientId=clientId;
        this.feed=feed;

    }

}
