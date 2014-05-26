package sum.tournament;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sum.model.Player;
import sum.tournament.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText ed_email = null;
	private EditText ed_password = null;
	private String sEmail, sPassword;
	private Button bt_login;
	private JSONParser jsonParser = new JSONParser();
	private static final String playersURL = "http://sighvatur.dk/sum/get_all_player.php";

	private static final String TAG_PLAYERS = "players";
	private static final String TAG_EMAIL = "email";
	private static final String TAG_NAME = "name";
	private static final String TAG_PHONENUMBER = "phoneNumber";
	private static final String TAG_PASSWORD = "password";
	private static final String TAG_ADMIN = "admin";

	JSONArray players = null;
	List<Player> playerList = new ArrayList<Player>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		ed_email = (EditText) findViewById(R.id.editText1);
		ed_password = (EditText) findViewById(R.id.editText2);
		bt_login = (Button) findViewById(R.id.button1);
		setFont();
		new LoadALlPlayers().execute();
		bt_login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				login(v);
			}
		});
	}

	public void login(View view) {
		sEmail = ed_email.getText().toString().trim();
		sPassword = ed_password.getText().toString().trim();
		if (validateCredentials(sEmail,sPassword)) {
			Toast.makeText(getApplicationContext(), "Redirecting...",
					Toast.LENGTH_SHORT).show();

			Intent intent = new Intent(MainActivity.this, Home.class);
			intent.putExtra("EMAIL", ed_email.getText().toString());
			startActivity(intent);

		} else {
			Toast.makeText(getApplicationContext(), "Wrong Credentials",
					Toast.LENGTH_SHORT).show();
		}

	}

	private boolean validateCredentials(String sEmail, String sPassword) {
		boolean found = false;
		int index = 0;
		for(Player p : playerList){
			Log.d("PLAYER",p.toString());
		}
		while(!found && index < playerList.size()){
			if(playerList.get(index).getEmail().equals(sEmail) && playerList.get(index).getPassword().equals(sPassword)){
				
				found = true;
			}
			index++;
		}
		Log.d("FOUND:" , found+"");
		return found;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void setFont() {
		Typeface loadingType = Typeface.createFromAsset(this.getAssets(),
				"varsity_regular.ttf");
		ed_email.setTypeface(loadingType);
		ed_password.setTypeface(loadingType);
		bt_login.setTypeface(loadingType);
		ed_email.setGravity(Gravity.CENTER);
		ed_password.setGravity(Gravity.CENTER);
		
	}

	class LoadALlPlayers extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */

		/**
		 * getting All products from url
		 * */
		protected String doInBackground(String... args) {
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// getting JSON string from URL
			JSONObject json = jsonParser.makeHttpRequest(playersURL, "GET",
					params);

			// Check your log cat for JSON reponse
			try {
				players = json.getJSONArray(TAG_PLAYERS);

				for (int i = 0; i < players.length(); i++) {
					JSONObject p = players.getJSONObject(i);
					
					String email = p.getString(TAG_EMAIL);
					String name = p.getString(TAG_NAME);
					String phonenumber = p.getString(TAG_PHONENUMBER);
					String password = p.getString(TAG_PASSWORD);
					String admin = p.getString(TAG_ADMIN);
					boolean isAdmin = false;
					if(admin == "\u0001"){
						isAdmin = true;
					}
					Player player = new Player(name,email,phonenumber,password,isAdmin);
					playerList.add(player);
					
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
}