package com.example.profesormanana.adapters;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //El componente de tipo AdapterView
        ListView listado = (ListView) findViewById(R.id.listado);

        //El objeto Collection
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Victor","Herrero"));
        personas.add(new Persona("Juan","Perez"));
        personas.add(new Persona("Manuel","Martinez"));
        personas.add(new Persona("Maria","Gomez"));
        personas.add(new Persona("Pedro","Duque"));


        //Referencia al xml de Layout
        //int layout = android.R.layout.simple_list_item_1;
        int layout = R.layout.persona_list_item;

        //Un objeto de tipo Adapter, que relaciona los otros componentes
        //ListAdapter adaptador = new ArrayAdapter<Persona>(this,layout,personas);

        PersonaAdapter adaptador = new PersonaAdapter(this, layout, personas);

        listado.setAdapter(adaptador);

    }
}
