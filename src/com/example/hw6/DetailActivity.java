package com.example.hw6;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends Activity {
	private ImageView imageloaded;
	ProgressBar progressbar;
	private TextView title , owner,pubdate;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		// Fetch views
		imageloaded = (ImageView) findViewById(R.id.imageView1);
		title = (TextView) findViewById(R.id.textView1);
		pubdate = (TextView) findViewById(R.id.textView2);
		owner = (TextView) findViewById(R.id.textView3);

Photos piclists = (Photos) getIntent().getSerializableExtra(MainActivity.PICTURE_DETAIL);
		loadPic(piclists);
	}
	
	// Populate the pic info
	@SuppressLint("NewApi")
	public void loadPic(Photos piclists) {
		// Populate info
		title.setText(piclists.getTitle());
		owner.setText(piclists.getOwner());
		pubdate.setText(piclists.getPubdate());
		Picasso.with(this).load(piclists.getPosterUrl()).
		    placeholder(R.drawable.imagepic).
		    into(imageloaded);
	}

}
