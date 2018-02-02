/*
 * Tweetable
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
 * An interface for a tweet
 *
 * @author Malcolm MacArthur
 * @version 1.5
 * @see NormalTweet
 * @see ImportantTweet
 */

public interface Tweetable {
    public String getMessage();
    public Date getDate();
}
