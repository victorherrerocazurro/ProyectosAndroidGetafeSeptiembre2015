package com.example.profesormanana.preferencias;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View btConfigurar = findViewById(R.id.btConfigurar);

        View btSaludar = findViewById(R.id.btSaludar);

        btConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                Intent intent = new Intent(MainActivity.this, SettingsAutomaticoActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                String prefijo = preferences.getString(
                        SettingsActivity.KEY_PREFIJO,
                        MainActivity.this.getResources().getString(R.string.default_prefijo));
                String sufijo = preferences.getString(
                        SettingsActivity.KEY_SUFIJO,
                        MainActivity.this.getResources().getString(R.string.default_sufijo));

                String saludo = prefijo + etNombre.getText().toString() + sufijo;

                Toast.makeText(MainActivity.this,saludo,Toast.LENGTH_LONG).show();
            }
        });

        etNombre = (EditText) findViewById(R.id.etNombre);


    }
}
