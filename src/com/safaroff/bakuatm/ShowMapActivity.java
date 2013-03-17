package com.safaroff.bakuatm;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.safaroff.bakuatm.models.ATM;

import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;

public class ShowMapActivity extends FragmentActivity {
	
	private GoogleMap mMap;
	private ATM atm = new ATM("\"Yamaha\" mağazası", "H.Cavid pr. 528 məh", null, new LatLng(40.397157, 49.82583));
	
	private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
        	mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        // Hide the zoom controls as the button panel will cover it.
        mMap.getUiSettings().setZoomControlsEnabled(false);

        // Add marker to the map.
        addMarkerToMap();

        /*// Set listeners for marker events.  See the bottom of this class for their behavior.
        mMap.setOnMarkerClickListener((OnMarkerClickListener) this);
        mMap.setOnInfoWindowClickListener((OnInfoWindowClickListener) this);
        mMap.setOnMarkerDragListener((OnMarkerDragListener) this);*/

        // Pan to see all markers in view.
        // Cannot zoom to bounds until the map has a size.
        final View mapView = getSupportFragmentManager().findFragmentById(R.id.map).getView();
        if (mapView.getViewTreeObserver().isAlive()) {
            mapView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                @SuppressWarnings("deprecation") // We use the new method when supported
                @SuppressLint("NewApi") // We check which build version we are using.
                @Override
                public void onGlobalLayout() {
                    LatLngBounds bounds = new LatLngBounds.Builder()
                    		.include(atm.latLng)
                            .build();
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                      mapView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                      mapView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50));
                }
            });
        }
    }

    private void addMarkerToMap() {
    	// Uses a colored icon.
    	mMap.addMarker(new MarkerOptions()
                .position(atm.latLng)
                .title(atm.shortAddress)
                .snippet(atm.longAddress)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        /*// Creates a marker rainbow demonstrating how to create default marker icons of different
        // hues (colors).
        int numMarkersInRainbow = 12;
        for (int i = 0; i < numMarkersInRainbow; i++) {
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(
                            -30 + 10 * Math.sin(i * Math.PI / (numMarkersInRainbow - 1)),
                            135 - 10 * Math.cos(i * Math.PI / (numMarkersInRainbow - 1))))
                    .title(atm.shortAddress)
                    .icon(BitmapDescriptorFactory.defaultMarker(i * 360 / numMarkersInRainbow)));
        }*/
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_map);
		// Show the Up button in the action bar.
		setupActionBar();
		
		setUpMapIfNeeded();
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_map, menu);
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
