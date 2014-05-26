package sum.tournament;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sum.model.Match;
import sum.tournament.SpecificTournamentFragment.LoadALlPlayers;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MatchActivity extends Activity {

	private TextView tv_tournament_name;

	private String name;
	private String TAG_TOURNAMENT_NAME = "name";
	private ProgressDialog pDialog;
	private JSONParser jsonParser = new JSONParser();
	private TextView tv_m1_p1, tv_m1_p2, tv_m2_p1, tv_m2_p2, tv_m3_p1,
			tv_m3_p2, tv_m4_p1, tv_m4_p2, tv_m5_p1, tv_m5_p2, tv_m6_p1,
			tv_m6_p2, tv_m7_p1, tv_m7_p2;

	private static final String TAG_MATCHES = "matches";
	private static final String TAG_MATCHNUMBER = "MatchNumber";
	private static final String TAG_PLAYER1_NAME = "p1Name";
	private static final String TAG_PLAYER2_NAME = "p2Name";
	private static final String TAG_WINNER_NAME = "winner";

	private List<Match> matches;
	private JSONArray matchJSON;

	private final String matchURL = "http://sighvatur.dk/sum/get_matches_in_tournament.php";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.matchlayout);
		matches = new ArrayList<Match>();
		initialize();
		Intent i = getIntent();
		name = i.getStringExtra("TOURNAMENT_NAME");
		tv_tournament_name.setText(i.getStringExtra("TOURNAMENT_NAME"));
		Typeface listType = Typeface.createFromAsset(getAssets(),
				"varsity_regular.ttf");
		tv_tournament_name.setTypeface(listType);
		tv_tournament_name.setTextColor(Color.WHITE);
		
		new LoadALlPlayers().execute();	
	
	}

	private void initialize() {
		tv_tournament_name = (TextView) findViewById(R.id.tv_tournament_name);
		tv_m1_p1 = (TextView) findViewById(R.id.tv_match1_p1);
		tv_m1_p2 = (TextView) findViewById(R.id.tv_match1_p2);
		tv_m2_p1 = (TextView) findViewById(R.id.tv_match2_p1);
		tv_m2_p2 = (TextView) findViewById(R.id.tv_match2_p2);
		tv_m3_p1 = (TextView) findViewById(R.id.tv_match3_p1);
		tv_m3_p2 = (TextView) findViewById(R.id.tv_match3_p2);
		tv_m4_p1 = (TextView) findViewById(R.id.tv_match4_p1);
		tv_m4_p2 = (TextView) findViewById(R.id.tv_match4_p2);
		tv_m5_p1 = (TextView) findViewById(R.id.tv_match5_p1);
		tv_m5_p2 = (TextView) findViewById(R.id.tv_match5_p2);
		tv_m6_p1 = (TextView) findViewById(R.id.tv_match6_p1);
		tv_m6_p2 = (TextView) findViewById(R.id.tv_match6_p2);
		tv_m7_p1 = (TextView) findViewById(R.id.tv_match7_p1);
		tv_m7_p2 = (TextView) findViewById(R.id.tv_match7_p2);
	}

	class LoadALlPlayers extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */

		/**
		 * getting All products from url
		 * */

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(MatchActivity.this);
			pDialog.setMessage("Loading matches. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		protected String doInBackground(String... args) {
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair(TAG_TOURNAMENT_NAME, name));
			// getting JSON string from URL
			JSONObject json = jsonParser.makeHttpRequest(matchURL, "GET",
					params);

			Log.d("JSON", json.toString());

			try {
				matchJSON = json.getJSONArray(TAG_MATCHES);

				for (int i = 0; i < matchJSON.length(); i++) {
					JSONObject match = matchJSON.getJSONObject(i);
					String matchNumber = match.getString(TAG_MATCHNUMBER);
					String player1 = match.getString(TAG_PLAYER1_NAME);
					String player2 = match.getString(TAG_PLAYER2_NAME);
					String winner = match.getString(TAG_WINNER_NAME);

					Match newMatch = new Match(player1, player2, matchNumber);
					newMatch.setWinnerName(winner);
					matches.add(newMatch);
					Log.d("MATCH", matches.get(i).toString());
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			pDialog.dismiss();
			updateBrackets();
		}

		private void updateBrackets() {
			tv_m1_p1.setText(matches.get(0).getPlayer1Name());
			tv_m1_p2.setText(matches.get(0).getPlayer2Name());
			tv_m2_p1.setText(matches.get(1).getPlayer1Name());
			tv_m2_p2.setText(matches.get(1).getPlayer2Name());
			tv_m3_p1.setText(matches.get(2).getPlayer1Name());
			tv_m3_p2.setText(matches.get(2).getPlayer2Name());
			tv_m4_p1.setText(matches.get(3).getPlayer1Name());
			tv_m4_p2.setText(matches.get(3).getPlayer2Name());
			tv_m5_p1.setText(matches.get(0).getWinnerName());
			tv_m5_p2.setText(matches.get(1).getWinnerName());
			tv_m6_p1.setText(matches.get(2).getWinnerName());
			tv_m6_p2.setText(matches.get(3).getWinnerName());
			tv_m7_p1.setText(matches.get(4).getWinnerName());
			tv_m7_p2.setText(matches.get(5).getWinnerName());

			colorWinnerField();
		}

		private void colorWinnerField() {
			if (matches.get(0).getWinnerName().equals(tv_m1_p1.getText().toString())) {
				tv_m1_p1.setTextColor(Color.GREEN);
			} else {
				tv_m1_p2.setTextColor(Color.GREEN);
			}
			Log.d("m2", tv_m2_p1.getText().toString());
			Log.d("m2 winner", matches.get(1).getWinnerName());
			if (matches.get(1).getWinnerName().equals(tv_m2_p1.getText().toString())) {
				
				tv_m2_p1.setTextColor(Color.GREEN);
			} else {
				tv_m2_p2.setTextColor(Color.GREEN);
			}

			if (matches.get(2).getWinnerName().equals(tv_m3_p1.getText().toString())) {
				tv_m3_p1.setTextColor(Color.GREEN);
			} else {
				tv_m3_p2.setTextColor(Color.GREEN);
			}

			if (matches.get(3).getWinnerName().equals(tv_m4_p1.getText().toString())) {
				tv_m4_p1.setTextColor(Color.GREEN);
			} else {
				tv_m4_p2.setTextColor(Color.GREEN);
			}

			if (matches.get(4).getWinnerName().equals(tv_m5_p1.getText().toString())) {
				tv_m5_p1.setTextColor(Color.GREEN);
			} else {
				tv_m5_p2.setTextColor(Color.GREEN);
			}

			if (matches.get(5).getWinnerName().equals(tv_m6_p1.getText().toString())) {
				tv_m6_p1.setTextColor(Color.GREEN);
			} else {
				tv_m6_p2.setTextColor(Color.GREEN);
			}

			if (matches.get(6).getWinnerName().equals(tv_m7_p1.getText().toString())) {
				tv_m7_p1.setTextColor(Color.GREEN);
			} else {
				tv_m7_p2.setTextColor(Color.GREEN);
			}
		}
	}
}
