package com.example.hw6;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
	import com.loopj.android.http.AsyncHttpClient;
	import com.loopj.android.http.JsonHttpResponseHandler;
	import com.loopj.android.http.RequestParams;
	

public class PhotoUtil {

	private AsyncHttpClient client;

		public PhotoUtil() {
			this.client = new AsyncHttpClient();
		}

		public void getPicsInfos(JsonHttpResponseHandler handler) {
		
			String url = ("http://www.panoramio.com/map/get_panoramas.php?set=public&from=0&to=50&size=medium");
		
			client.get(url, handler);
		}

	}