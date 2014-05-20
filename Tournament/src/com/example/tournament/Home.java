package com.example.tournament;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends Activity{
		
	private TextView playerName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		initialize();
		
		Intent i = getIntent();
		playerName.setText(i.getStringExtra("NAME"));
	}
	private void initialize() {
//		playerName = (TextView)findViewById(R.id.tv_homeName);
	}
}
