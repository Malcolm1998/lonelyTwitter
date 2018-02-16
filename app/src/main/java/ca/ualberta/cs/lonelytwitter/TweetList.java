/*
 * Copyright © 2018 Team X, CMPUT301, University of Alberta - All rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code
 * of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise contact mimacart@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

/**
 * Created by malcolmmacarthur on 2018-02-13.
 */

import java.util.ArrayList;

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet){
        for (Tweet tweetInstance: tweets){
            if (tweetInstance.getMessage().equals(tweet.getMessage())){
                throw new java.lang.IllegalArgumentException();
            }
        }

        tweets.add(tweet);

    }

    public boolean hasTweet(Tweet tweet) {
        for (Tweet tweetInstance: tweets){
            if (tweetInstance.getMessage().equals(tweet.getMessage())){
                return true;
            }

        }

        return false;
    }

    public Tweet getTweet(int index){

        return tweets.get(index);

    }

    public void delete(Tweet tweet){

        tweets.remove(tweet);

    }

    public ArrayList<Tweet> getTweets(){
        return tweets;
    }

    public int getCount(){
        return tweets.size();
    }
}
