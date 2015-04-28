package com.example.hw6;



import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ListAdapter extends ArrayAdapter<Photos> {
	public ListAdapter(Context context, ArrayList<Photos> aPics) {
		super(context, 0, aPics);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get the data item for this position
		Photos piclist = getItem(position);
		// Check if an existing view 
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
    		convertView = inflater.inflate(R.layout.activity_test, null);
		}
		// Lookup view for data population
		TextView pTitle = (TextView) convertView.findViewById(R.id.textView1);
		//TextView pPublish = (TextView) convertView.findViewById(R.id.textView2);
		//TextView pOwner = (TextView) convertView.findViewById(R.id.textView3);
		//adds image to list view>>>>ImageView imageloaded = (ImageView) convertView.findViewById(R.id.imageView1);
		// Populate the info into object
		pTitle.setText(piclist.getTitle());
		//pPublish.setText(piclist.getPubdate());
		//pOwner.setText(piclist.getOwner());
		//adds image to list view>>>Picasso.with(getContext()).load(piclist.getPosterUrl()).into(imageloaded);
		// Return the completed view
		return convertView;
	}
}
