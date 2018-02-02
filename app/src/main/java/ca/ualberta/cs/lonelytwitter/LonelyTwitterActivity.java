/*
 * LonelyTwitterActivity
 *
 * Version 1.5
 *
 * January 30, 2018
 *
 * Copyright © 2018 Team X, CMPUT301, University of Alberta - All rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code
 * of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise contact mimacart@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 *  The main class for Lonely Twitter
 *
 * 	@author Malcolm MacArthur
 *  @version 1.1
 *  @see ImportantTweet
 *  @see NormalTweet
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "tweets.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

	/**
	 * Called after onCreate, it fills the activity and set functionality to buttons
	 *
	 * @param savedInstanceState the state from last opening
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("LifeCycle ---->", "onCreate is called");
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			/**
			 * sets save functionality
			 *
			 * @param v the view
			 */
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);
				bodyText.setText("");

				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			/**
			 * sets clear functionality
			 *
			 * @param v the view
			 */
			public void onClick(View v) {
				clearFile();
				saveInFile();

				adapter.notifyDataSetChanged();
			}
		});
	}

	/**
	 * called when the activity is created
	 */
	@Override
	protected void onStart() {

		// TODO Auto-generated method stub
		super.onStart();
		Log.i("LifeCycle --->", "OnStart is called");

		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);

	}

	/**
	 * Loads the tweet from a file
	 *
	 * @throws RuntimeException the file is not found or somethings wrong with IO
	 */
	private void loadFromFile() {

		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			// Taken https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-type
			// 2018-01-23

			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}

	}

	/**
	 * Saves the tweet into a file
	 *
	 * @throws RuntimeException the file is not found or somethings wrong with IO
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * Clears the tweet list which is in turn be saved into the file
	 */
	private void clearFile() {
		tweetList.clear();
	}


	/**
	 * called before activity is destroyed
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Lifecycle", "onDestroy is called");
	}
}