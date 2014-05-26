package sum.tournament;


import sum.tournament.R;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Gets the Service object singleton so class to db can be made
		
		//creates an actionbar with tabs
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		//adds 3 tabs to actionbar, each having a tabbarlistener on with a tag and a fragment class
		Tab tabA = actionBar.newTab();
		tabA.setText("Tournaments");
		tabA.setTabListener(new TabListener<AllTournamentFragment>(this, "All Tournaments",
				AllTournamentFragment.class));
		actionBar.addTab(tabA);

		Tab tabB = actionBar.newTab();
		tabB.setText("My Tournaments");
		tabB.setTabListener(new TabListener<SpecificTournamentFragment>(this,
				"Specific Tournament", SpecificTournamentFragment.class));
		actionBar.addTab(tabB);

		Tab tabC = actionBar.newTab();
		tabC.setText("Upcoming Games");
		tabC.setTabListener(new TabListener<FutureGamesFragment>(this, "Upcoming Games",
				FutureGamesFragment.class));
		actionBar.addTab(tabC);

		if (savedInstanceState != null) {
			int savedIndex = savedInstanceState.getInt("SAVED_INDEX");
			getActionBar().setSelectedNavigationItem(savedIndex);
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("SAVED_INDEX", getActionBar()
				.getSelectedNavigationIndex());
	}
	
	//when the game is over and this method handles the intent called from method SwitchTabs() and reattches the fragment to simulate new game start
	protected void onNewIntent(Intent intent, FragmentTransaction ft) {
		super.onNewIntent(intent);
		
		Fragment myFragment = this.getFragmentManager()
				.findFragmentByTag("All Tournaments");
		if (myFragment == null) {
			myFragment = Fragment
					.instantiate(this, AllTournamentFragment.class.getName());
			
			ft.add(android.R.id.content, myFragment, "All Tournaments");
		} else {
			ft.attach(myFragment);
		}
	
	}

	//TabListener class whichs extends a fragment and imple,ents tabListener
	public static class TabListener<T extends Fragment> implements
			ActionBar.TabListener {

		private final Activity myActivity;
		private final String myTag;
		private final Class<T> myClass;

		public TabListener(Activity activity, String tag, Class<T> cls) {
			myActivity = activity;
			myTag = tag;
			myClass = cls;
		}

		@Override
		
		//uses the fragmentTransaction to put the fragment which belongs to the tab selected, on top so it is shown
		public void onTabSelected(Tab tab, FragmentTransaction ft) {

			Fragment myFragment = myActivity.getFragmentManager()
					.findFragmentByTag(myTag);

			if (myFragment == null) {
				myFragment = Fragment
						.instantiate(myActivity, myClass.getName());
				ft.add(android.R.id.content, myFragment, myTag);
			} else {
				ft.attach(myFragment);
			}

		}
		

		@Override
		//when a tab is left it gets detached
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {

			Fragment myFragment = myActivity.getFragmentManager()
					.findFragmentByTag(myTag);

			if (myFragment != null) {
				ft.detach(myFragment);
			}

		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
		}

	}
}
