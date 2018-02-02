/*
 * NormalTweet
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
 * Represents a normal tweet
 *
 * @author Malcolm MacArthur
 * @version 1.0
 * @see Tweet
 * @see ImportantTweet
 */
public class NormalTweet extends Tweet {

    /**
     * Constructs a NormalTweet object with a message
     *
     * @param message the message to be saved
     */
    NormalTweet(String message){
        super(message);
    }

    /**
     * Constructs a NormalTweet object with a message and date
     *
     * @param message the message to be saved
     * @param date the date to be saved
     */
    NormalTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Returns whether the tweet instance is important
     *
     * @return a bool
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
