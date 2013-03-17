package com.safaroff.bakuatm;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** Called when the user clicks the Choose Banks button */
	public void listBanks(View view) {
		Intent intent = new Intent(this, ListBanksActivity.class);
		
		startActivity(intent);
	}
	
	/** Called when the user clicks the List ATMs button */
	public void listATMs(View view) {
		Intent intent = new Intent(this, ATMListActivity.class);
		
		startActivity(intent);
	}
}
