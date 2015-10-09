package com.getafe.profesormanana.googlemaps;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                                                .findFragmentById(R.id.mapFragment);

        final GoogleMap map = mapFragment.getMap();

        //map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Toast.makeText(MainActivity.this, "Latitud: " + latLng.latitude + "; Longitud: " + latLng.longitude, Toast.LENGTH_SHORT).show();

                /*CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(latLng); //new LatLng(40.0, -4.0)
                CameraUpdate cameraUpdate1 = CameraUpdateFactory.zoomTo(21.0f);
                map.animateCamera(cameraUpdate);
                map.animateCamera(cameraUpdate1);*/

                CameraPosition cameraPosition = new CameraPosition(
                        latLng,
                        6,
                        45,
                        90
                );
                CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
                map.animateCamera(cameraUpdate);


                MarkerOptions markerOptions = new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_gallery))
                        .position(latLng)
                        .title("Nuestra Marca");


                Marker marker = map.addMarker(markerOptions);

            }
        });


        PolygonOptions polygonOptions = new PolygonOptions();

        polygonOptions.add(new LatLng(40, -4), new LatLng(30, -4), new LatLng(30, 4), new LatLng(40, 4));

        polygonOptions.fillColor(Color.GREEN);

        map.addPolygon(polygonOptions);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
