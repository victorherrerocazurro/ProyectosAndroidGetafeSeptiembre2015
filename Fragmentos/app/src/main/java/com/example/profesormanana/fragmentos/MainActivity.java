package com.example.profesormanana.fragmentos;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity {

    private ListadoFragment fragmentoListado;
    private DetalleCorreoElectronicoFragment fragmentoDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentoListado = (ListadoFragment) getFragmentManager()
                                                    .findFragmentById(R.id.fragmentListado);

        fragmentoDetalle = (DetalleCorreoElectronicoFragment) getFragmentManager()
                                                    .findFragmentById(R.id.fragmentDetalle);

        List<CorreoElectronico> listadoCorreos = new LinkedList<>();

        listadoCorreos.add(
                new CorreoElectronico(
                        "Asunto", "Remitente", "Destinatario", "Contenido", new Date(), new Date()));
        listadoCorreos.add(
                new CorreoElectronico(
                        "Asunto2", "Remitente2", "Destinatario2", "Contenido2", new Date(), new Date()));
        listadoCorreos.add(
                new CorreoElectronico(
                        "Asunto3", "Remitente3", "Destinatario3", "Contenido3", new Date(), new Date()));
        listadoCorreos.add(
                new CorreoElectronico(
                        "Asunto4", "Remitente4", "Destinatario4", "Contenido4", new Date(), new Date()));

        fragmentoListado.setListado(listadoCorreos);

        fragmentoListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CorreoElectronico item = (CorreoElectronico) parent.getAdapter().getItem(position);

                if(fragmentoDetalle != null){
                    //En Tablet
                    fragmentoDetalle.actualizarDetalle(item);
                } else {
                    //Smartphone
                    Intent intent = new Intent(MainActivity.this, DetalleActivity.class);

                    intent.putExtra("dato", item);

                    startActivity(intent);
                }

            }
        });

    }
}
