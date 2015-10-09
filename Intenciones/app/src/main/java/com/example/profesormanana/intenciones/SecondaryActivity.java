package com.example.profesormanana.intenciones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class SecondaryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Intent intent = getIntent();

        Persona dato = (Persona) intent.getSerializableExtra("dato");

        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);

        tvResultado.setText("Saludos a :" + dato.getNombre() + " " + dato.getApellido());

    }


}
