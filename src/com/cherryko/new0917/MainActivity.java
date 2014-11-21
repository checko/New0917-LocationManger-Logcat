
package com.cherryko.new0917;

import java.util.List;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity implements LocationListener {
    
    LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("ABD","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lm = (LocationManager)getSystemService(LOCATION_SERVICE);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        List<String> allProviders = lm.getProviders(true);
        for (int i=0;i<allProviders.size();i++)
            Log.d("ABC",": " + allProviders.get(i));
        
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        
        Location location = lm.getLastKnownLocation("gps");
        if (location == null) {
            Log.d("ABC", "Never get location");
            return;
        }
        
    }
    
    @Override
    protected void onStop() {
    	lm.removeUpdates(this);
    	super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onLocationChanged(Location arg0) {
        // TODO Auto-generated method stub
        Log.d("ABC","onLocationChanged");
        Log.d("ABC","Location: " + arg0.getLatitude() +", " + arg0.getLongitude());
        
    }

    @Override
    public void onProviderDisabled(String arg0) {
        // TODO Auto-generated method stub
        Log.d("ABC","onProviderDisabled");
        
    }

    @Override
    public void onProviderEnabled(String arg0) {
        // TODO Auto-generated method stub
        Log.d("ABC","onProviderEnabled");
        
    }

    @Override
    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
        // TODO Auto-generated method stub
        Log.d("ABC", "Status Changed..");
        
    }
    
    

}
