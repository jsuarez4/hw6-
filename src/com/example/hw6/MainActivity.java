package com.example.hw6;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

public class MainActivity extends Activity {
	private ListView picinfo;
	private ListAdapter adapterPics;
	private PhotoUtil client;
	public static final String PICTURE_DETAIL = "detail";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		picinfo = (ListView) findViewById(R.id.listView1);
		ArrayList<Photos> aPics = new ArrayList<Photos>();
		adapterPics = new ListAdapter(this, aPics);
		picinfo.setAdapter(adapterPics);
		// Fetch the info
		fetchPicInfo();
		setupMovieSelectedListener();
	}

	private void fetchPicInfo() {
		client = new PhotoUtil();
		client.getPicsInfos(new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(int code, JSONObject doc) {
				JSONArray items = null;
				try {
					// Get the movies json array
					items = doc.getJSONArray("photos");
					// Parse json array into array of model objects
					ArrayList<Photos> pics = Photos.fromJson(items);
					// Load model objects into the adapter which displays them
					adapterPics.addAll(pics);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setupMovieSelectedListener() {
		picinfo.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View item, int position, long rowId) {
				Intent i = new Intent(MainActivity.this, DetailActivity.class);
				i.putExtra(PICTURE_DETAIL, adapterPics.getItem(position));
				startActivity(i);
			}
		});
	}

}
