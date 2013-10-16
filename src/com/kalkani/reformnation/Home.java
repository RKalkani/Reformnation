package com.kalkani.reformnation;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Home extends ActionBarActivity {

	private String[] headings = null;
	private ArrayList<Data> data = null;
	private ListView list = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		init();		
		data = new ArrayList<Data>();
		
		for(int i = 0; i < headings.length; i++)
		{
			try {
				data.add(new Data(i, headings[i]));
			} catch (ArrayIndexOutOfBoundsException e) {
				data.add(new Data(i, " "));
			}
		}
		
		list.setAdapter(new MyListAdapter(Home.this, data));
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				Intent intent = new Intent(Home.this, Detail.class);
				intent.putExtra("KEY", position);
				startActivity(intent);
				
			}
		});
		
	}

	private void init() {
		Resources resources = getResources();
		headings = resources.getStringArray(R.array.heading);		
		list = (ListView) findViewById(R.id.home_list);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.home, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}

}
