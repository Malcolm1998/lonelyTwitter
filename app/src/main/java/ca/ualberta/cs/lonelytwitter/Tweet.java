package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by malcolmmacarthur on 2018-01-16.
 */

public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;
    /** https://stackoverflow.com/questions/5613311/list-of-classes-in-java */

    Tweet(String message) {

        this.message = message;
        date = new Date();
        //message = message;
    }

    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length()  < 140){
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public abstract Boolean isImportant();

    public String toString() {
        return date.toString() + " | " + message;
    }

}
