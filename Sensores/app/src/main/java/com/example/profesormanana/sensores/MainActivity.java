package com.example.profesormanana.sensores;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private  Sensor sensorAcelerometro;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<Sensor> adapter = new ArrayAdapter<Sensor>(this, android.R.layout.simple_list_item_1, sensorList);

        listView.setAdapter(adapter);

        sensorAcelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        textView = (TextView) findViewById(R.id.textView);

    }

    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(this, sensorAcelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        sensorManager.unregisterListener(this);
    }

    //Metodos al implementar la interface SensorEventListener

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;

        textView.setText("X=" + values[0] + " m/s2; Y=" + values[1] + " m/s2; Z=" + values[2] + " m/s2");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
