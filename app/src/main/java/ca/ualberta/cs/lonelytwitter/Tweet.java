
/*
 * Tweet
 *
 * Version 1.0
 *
 * January 30, 2018
 *
 * Copyright © 2018 Team X, CMPUT301, University of Alberta - All rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code
 * of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise contact mimacart@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a tweet.
 *
 * @author Malcolm MacArthur
 * @version 1.5
 * @see NormalTweet
 * @see ImportantTweet
 */
public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;

    /**
     * Constructs a tweet object
     *
     * @param message tweet message
     */
    Tweet(String message) {

        this.message = message;
        date = new Date();
        //message = message;
    }

    /**
     * Constructs a tweet object.
     *
     * @param message tweet message
     * @param date tweet date
     */
    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     * Gets the message in a class instance
     *
     * @return
     */
    public String getMessage(){
        return message;
    }

    /**
     * Sets tweet message
     *
     * @param message tweet message
     * @throws TweetTooLongException the tweet message is over 140 characters
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length()  < 140){
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    /**
     * Gets the date in a class instance
     *
     * @return returns the date
     */
    public Date getDate(){
        return date;
    }

    /**
     * Sets the date in a class instance
     *
     * @param date the date to be set/savee
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     * Returns whether the tweet instance is important
     *
     * @return a bool
     */
    public abstract Boolean isImportant();

    /**
     * Returns a formatted string with a date and message
     *
     * @return a string
     */
    public String toString() {
        return date.toString() + " | " + message;
    }

}
