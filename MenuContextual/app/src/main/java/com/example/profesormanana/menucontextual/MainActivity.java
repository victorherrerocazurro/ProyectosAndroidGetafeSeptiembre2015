package com.example.profesormanana.menucontextual;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.profesormanana.menucontextual.modelo.entidades.Pelicula;
import com.example.profesormanana.menucontextual.modelo.servicio.Servicio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity {

    public static final int REQUEST_CODE_EDICION = 0;
    private ArrayAdapter<Pelicula> adapter;
    private ListView lvPeliculas;
    private Servicio servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Registrar lvPeliculas como componente con menu contextual

        lvPeliculas = (ListView) findViewById(R.id.lvPeliculas);

        CarteleraApplication context = (CarteleraApplication) getApplicationContext();

        //Esta linea es necesaria cuando no tenemos la arquitectura MVC
        /*List<Pelicula> listado = new ArrayList<>();
        listado.add(new Pelicula(120,"Lo que el viento se llevo","18:00 20:00 22:00", "Drama"));
        listado.add(new Pelicula(120,"Casablanca","18:00 20:00 22:00", "Drama"));
        listado.add(new Pelicula(120,"Mad Max","18:00 20:00 22:00", "Ciencia Ficcion"));
        listado.add(new Pelicula(120,"Rec","18:00 20:00 22:00", "Terror"));*/

        //Cuando tenemos MVC
        servicio = context.getServicio();

        List<Pelicula> listado = servicio.getTodasPeliculas();

        adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, listado);

        lvPeliculas.setAdapter(adapter);

        registerForContextMenu(lvPeliculas);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.lvPeliculas) {

            int position = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;

            //Pelicula item = adapter.getItem(position);

            Pelicula item = servicio.getPeliculaById(position);

            menu.setHeaderTitle(item.getTitulo());

            getMenuInflater().inflate(R.menu.menu_main, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //Pelicula peliculaItem = null;

        int position = ((AdapterView.AdapterContextMenuInfo) item.getMenuInfo()).position;

        //Esta linea es necesaria cuando no tenemos la arquitectura MVC
        //Pelicula peliculaItem = adapter.getItem(position);

        //MVC
        Pelicula peliculaItem = servicio.getPeliculaById(position);

        switch (item.getItemId()) {
            case R.id.action_edicion:
                //Abrir una nueva actividad que permite la edicion de la pelicula.
                Intent intent = new Intent(this, EdicionActivity.class);

                //Esta linea es necesaria cuando no tenemos la arquitectura MVC
                //intent.putExtra(EdicionActivity.PELICULA,peliculaItem);

                intent.putExtra(EdicionActivity.POSICION, position);
                startActivityForResult(intent, REQUEST_CODE_EDICION);
                return true;
            case R.id.action_borrar:
                //Esta linea es necesaria cuando no tenemos la arquitectura MVC
                //adapter.remove(peliculaItem);

                //MVC
                servicio.removePeliculaById(position);

                adapter.notifyDataSetChanged();
                return true;
            case R.id.action_info:
                //Abrir una nueva actividad que permita visualizar, pero no modificar
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_EDICION){
            if(resultCode == RESULT_OK){
                //No MVC
                //Pelicula peliculaModificada = (Pelicula) data.getSerializableExtra(EdicionActivity.PELICULA);
                //int posicion = data.getIntExtra(EdicionActivity.POSICION, -1);
                //Pelicula peliculaAntigua = adapter.getItem(posicion);
                //adapter.remove(peliculaAntigua);
                //adapter.insert(peliculaModificada,posicion);

                adapter.notifyDataSetChanged();
            }
        }
    }
}
