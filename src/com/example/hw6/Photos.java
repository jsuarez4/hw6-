package com.example.hw6;

import java.io.Serializable;


import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;

public class Photos implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title, owner ,posterUrl,pubdate;
	

	public static Photos fromJson(JSONObject jsonObject) {
		Photos b = new Photos();
		try {
			// Deserializ json into object fields
			b.title = jsonObject.getString("photo_title");
			b.owner = jsonObject.getString("owner_name");
			b.pubdate = jsonObject.getString("upload_date");
			b.posterUrl = jsonObject.getString("photo_file_url");

		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		// Return new object
		return b;
	}

	// Decodes array of  json results into objects
	public static ArrayList<Photos> fromJson(JSONArray jsonArray) {
		ArrayList<Photos> images = new ArrayList<Photos>(jsonArray.length());
		// Process each result in json 
		// object
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject dataJson = null;
			try {
				dataJson = jsonArray.getJSONObject(i);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}

			Photos image = Photos.fromJson(dataJson);
			if (image != null) {
				images.add(image);
			}
		}

		return images;
	}

	public String getTitle() {
		return title;
	}

	public String getPubdate() {
		return pubdate;
	}

	public String getOwner() {
		return owner;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

}
