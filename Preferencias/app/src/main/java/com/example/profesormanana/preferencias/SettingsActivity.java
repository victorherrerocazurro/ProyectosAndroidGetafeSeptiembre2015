package com.example.profesormanana.preferencias;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends Activity {

    public static final String KEY_PREFIJO = "prefijo";
    public static final String KEY_SUFIJO = "sufijo";
    private EditText etPrefijo;
    private EditText etSufijo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Obtener las referencias de los elementos View

        View btGuardar = findViewById(R.id.btGuardar);
        etPrefijo = (EditText) findViewById(R.id.etPrefijo);
        etSufijo = (EditText) findViewById(R.id.etSufijo);

        //Establecer los valores por defecto a mostrar en esos View

        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String prefijo = preferences.getString(KEY_PREFIJO, getResources().getString(R.string.default_prefijo));
        String sufijo = preferences.getString(KEY_SUFIJO, getResources().getString(R.string.default_sufijo));

        etPrefijo.setText(prefijo);
        etSufijo.setText(sufijo);

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(KEY_PREFIJO,etPrefijo.getText().toString());
                editor.putString(KEY_SUFIJO,etSufijo.getText().toString());

                editor.commit();
            }
        });
    }
}
