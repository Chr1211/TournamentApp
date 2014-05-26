package sum.tournament;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sum.model.Tournament;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SpecificTournamentFragment extends Fragment {

	private JSONParser jsonParser = new JSONParser();
	private static final String tournamentURL = "http://sighvatur.dk/sum/get_tournaments_player.php";

	private static final String TAG_TOURNAMENTS = "tournaments";
	private static final String TAG_TOURNAMENT_NAME = "name";
	private static final String TAG_STARTDATE = "startDate";
	private static final String TAG_ENDDATE = "endDate";
	private String TAG_PLAYER_EMAIL = "email";
	private String email;
	private ProgressDialog pDialog;
	

	private List<Tournament> tournaments = new ArrayList<Tournament>();
	private JSONArray tournamentsJSON = null;

	private ListView tournamentListView;
	private CustomListAdapter listAdapter;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.specifictournament, container,
				false);

		new LoadALlPlayers().execute();
		Intent i = getActivity().getIntent();
		email = i.getStringExtra("EMAIL");
		return rootView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);

		tournamentListView = (ListView)getActivity().findViewById(R.id.listView1);

		updateTournaments();

		tournamentListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> list, View view, int position,
					long id) {
				Intent myIntent = new Intent(getActivity(), MatchActivity.class);
				Tournament selTournament = (Tournament) list.getItemAtPosition(position);
				myIntent.putExtra("TOURNAMENT_NAME", selTournament.toString());
                getActivity().startActivity(myIntent); 
			}
		});

	}

	public void updateTournaments(){
		listAdapter = new CustomListAdapter(getActivity() , R.layout.custom_list , tournaments);
		tournamentListView.setAdapter(listAdapter);
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
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Loading products. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}
		
		protected String doInBackground(String... args) {
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair(TAG_PLAYER_EMAIL, email));
			Log.d("MAIL:", email);
			// getting JSON string from URL
			JSONObject json = jsonParser.makeHttpRequest(tournamentURL, "GET",
					params);
			
			Log.d("JSON", json.toString());

			// Check your log cat for JSON reponse
			try {
				tournamentsJSON = json.getJSONArray(TAG_TOURNAMENTS);
				tournaments.clear();
				for (int i = 0; i < tournamentsJSON.length(); i++) {
					JSONObject t = tournamentsJSON.getJSONObject(i);
					Log.d("JSON", t.toString());
					String name = t.getString(TAG_TOURNAMENT_NAME);
					String startDate = t.getString(TAG_STARTDATE);
					String endDate = t.getString(TAG_ENDDATE);

					Tournament tournament = new Tournament(name, startDate, endDate);
					tournaments.add(tournament);
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
			updateTournaments();
			pDialog.dismiss();
		}
	}
}
