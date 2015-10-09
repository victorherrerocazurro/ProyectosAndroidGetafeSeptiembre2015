package com.example.profesormanana.fragmentos;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DetalleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        DetalleCorreoElectronicoFragment fragment = (DetalleCorreoElectronicoFragment) getFragmentManager().findFragmentById(R.id.fragmentDetalle);

        CorreoElectronico item = (CorreoElectronico) getIntent().getSerializableExtra("dato");

        fragment.actualizarDetalle(item);
    }
}
