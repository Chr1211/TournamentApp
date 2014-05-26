package sum.tournament;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MatchActivity extends Activity {

	private TextView tv_tournament_name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.matchlayout);
			
		tv_tournament_name = (TextView)findViewById(R.id.tv_tournament_name);
		
		Intent i = getIntent();
		tv_tournament_name.setText(i.getStringExtra("TOURNAMENT_NAME"));
		
		Typeface listType = Typeface.createFromAsset(getAssets(), "varsity_regular.ttf");
        tv_tournament_name.setTypeface(listType);
        tv_tournament_name.setTextColor(Color.WHITE);
	}
}
