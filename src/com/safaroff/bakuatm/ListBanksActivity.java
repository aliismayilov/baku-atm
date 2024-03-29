package com.safaroff.bakuatm;

import java.util.ArrayList;
import java.util.List;

import com.safaroff.bakuatm.models.Bank;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class ListBanksActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_banks);
		// Show the Up button in the action bar.
		setupActionBar();
		
		
		// list of dummy banks
		List<Bank> listOfBanks = new ArrayList<Bank>();
		listOfBanks.add(new Bank("Good Bank", null));
		listOfBanks.add(new Bank("Bad Bank", null));
		listOfBanks.add(new Bank("Ugly Bank", null));
		
		// get root layout
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rootLinearLayout); 
		
		// iterate over dummy list and add checkbox
		for(Bank bank : listOfBanks) {
			// initialize check box
			CheckBox checkBox = new CheckBox(this);
			checkBox.setText(bank.name);
			checkBox.setTextSize(40);
			
			// add checkbox to the layout
			linearLayout.addView(checkBox);
		}
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_banks, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
