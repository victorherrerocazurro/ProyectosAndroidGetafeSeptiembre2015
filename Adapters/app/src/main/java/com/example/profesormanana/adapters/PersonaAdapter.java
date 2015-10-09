package com.example.profesormanana.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by profesormanana on 14/09/15.
 */
public class PersonaAdapter extends BaseAdapter {

    private List<Persona> datos;
    private Context contexto;
    private int layout;

    public PersonaAdapter(Context contexto, int layout, List<Persona> datos) {
        this.datos = datos;
        this.contexto = contexto;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            //Inflamos el arbol de Views que componente el View de cada Item

            LayoutInflater layoutInflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //LayoutInflater layoutInflater = ((Activity) contexto).getLayoutInflater();

            convertView = layoutInflater.inflate(layout, null);//Nueva vista
        }

        TextView textoNombre = (TextView)convertView.findViewById(R.id.personaNombre);
        TextView textoApellido = (TextView)convertView.findViewById(R.id.personaApellido);

        Persona item = datos.get(position);

        textoNombre.setText(item.getNombre());
        textoApellido.setText(item.getApellido());

        return convertView;
    }
}
