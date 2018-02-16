/*
 * Copyright © 2018 Team X, CMPUT301, University of Alberta - All rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code
 * of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise contact mimacart@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;

/**
 * Created by malcolmmacarthur on 2018-02-13.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }


    public void testHasTweet() {

        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        assertFalse(tweets.hasTweet(tweet));
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }


    public void testAddTweet() {

        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        assertFalse(tweets.hasTweet(tweet));
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
        try {
            tweets.addTweet(tweet);
        } catch (IllegalArgumentException e){
            assertTrue(Boolean.TRUE);
            return;
        }
        assertTrue(Boolean.FALSE);
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        assertEquals(0, tweets.getCount());
        tweets.addTweet(new NormalTweet("1"));
        tweets.addTweet(new NormalTweet("2"));
        tweets.addTweet(new NormalTweet("3"));
        assertEquals(3, tweets.getCount());
    }

    public void testGetTweet() {
        // using index
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");

        tweets.addTweet(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());
    }

    public void testGetTweets() {
        ArrayList<Tweet> tweetsArray;
        TweetList tweets = new TweetList();
        tweets.addTweet(new NormalTweet("1"));
        tweets.addTweet(new NormalTweet("2"));
        tweets.addTweet(new NormalTweet("3"));
        tweetsArray = tweets.getTweets();
        assertEquals(3, tweetsArray.size());
    }

    public void testDeleteTweet(){

        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");

        tweets.addTweet(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));

    }

}
