package com.example.profesormanana.cartelera;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.profesormanana.cartelera.modelo.entidades.Pelicula;
import com.example.profesormanana.cartelera.modelo.servicio.Servicio;

import java.util.List;

public class MainActivity extends Activity {

    private ListView lvCartelera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Elemento View
        lvCartelera = (ListView) findViewById(R.id.lvCartelera);

        CarteleraApplication contexto = (CarteleraApplication) getApplicationContext();

        Servicio servicio = contexto.getServicio();

        //Elemento Collection
        List<Pelicula> peliculas = servicio.getTodasPeliculas();

        //Elemento layout
        int layout = R.layout.cartelera_list_item;

        //Elemento Adapter
        PeliculasAdapter adapter = new PeliculasAdapter(this, peliculas, layout);

        //Relacionamos todos los elementos
        lvCartelera.setAdapter(adapter);

    }
}
