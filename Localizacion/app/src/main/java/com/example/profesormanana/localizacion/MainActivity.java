package com.example.profesormanana.localizacion;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity implements LocationListener {

    private LocationManager locationManager;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        List<String> providers = locationManager.getAllProviders();

        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, providers);

        listView.setAdapter(adapter);

        Criteria criteria = new Criteria();

        criteria.setAltitudeRequired(true);

        String bestProvider = locationManager.getBestProvider(criteria, false);

        Toast.makeText(MainActivity.this, "bestProvider = " + bestProvider, Toast.LENGTH_SHORT).show();

        if (checkPermission(Manifest.permission.ACCESS_FINE_LOCATION, 0, 0) != PackageManager.PERMISSION_GRANTED && checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION, 0, 0) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            //return;
        }
        locationManager.requestLocationUpdates(bestProvider, 3000, 500, this);

    }

    //Metodos que proporciona la implementacion de la interface LocationListener

    @Override
    public void onLocationChanged(Location location) {
        textView.setText("Latitud= " + location.getLatitude() + "; Longitud= " + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
