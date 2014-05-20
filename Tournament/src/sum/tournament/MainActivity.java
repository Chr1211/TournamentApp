package sum.tournament;

import sum.tournament.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{

	   private EditText  username=null;
	   private EditText  password=null;
	   private Button login;
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.login);
	      username = (EditText)findViewById(R.id.editText1);
	      password = (EditText)findViewById(R.id.editText2);
	      login = (Button)findViewById(R.id.button1);
	      login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				login(v);
			}
		});
	   }

	   public void login(View view){
	      if(username.getText().toString().equals("admin") && 
	      password.getText().toString().equals("admin")){
	      Toast.makeText(getApplicationContext(), "Redirecting...", 
	      Toast.LENGTH_SHORT).show();
	      
	      Intent intent = new Intent(MainActivity.this,Home.class);
	      intent.putExtra("NAME", username.getText().toString());
	      startActivity(intent);
	      
	   }	
	   else{
	      Toast.makeText(getApplicationContext(), "Wrong Credentials",
	      Toast.LENGTH_SHORT).show();
	   }

	}
	   @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      // Inflate the menu; this adds items to the action bar if it is present.
	      getMenuInflater().inflate(R.menu.main, menu);
	      return true;
	   }

	}
