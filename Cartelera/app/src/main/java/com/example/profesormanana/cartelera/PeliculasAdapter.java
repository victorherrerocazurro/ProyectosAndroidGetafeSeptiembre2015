package com.example.profesormanana.cartelera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.profesormanana.cartelera.modelo.entidades.Pelicula;

import java.util.List;

/**
 * Created by profesormanana on 15/09/15.
 */
public class PeliculasAdapter extends BaseAdapter {

    private int layout;
    private List<Pelicula> listado;
    private Context contexto;

    public PeliculasAdapter(Context contexto, List<Pelicula> listado, int layout) {
        this.contexto = contexto;
        this.listado = listado;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return this.listado.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listado.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout,null);

            ImageView ivCartel = (ImageView) convertView.findViewById(R.id.ivCartel);
            TextView txTitulo = (TextView) convertView.findViewById(R.id.txTitulo);
            TextView txDuracion = (TextView) convertView.findViewById(R.id.txDuracion);
            TextView txHorario = (TextView) convertView.findViewById(R.id.txHorario);

            /*convertView.setTag(0, ivCartel);
            convertView.setTag(1, txTitulo);
            convertView.setTag(2, txDuracion);
            convertView.setTag(3, txHorario);*/

            PeliculasAdapterDecorator peliculasAdapterDecorator = new PeliculasAdapterDecorator();

            peliculasAdapterDecorator.ivCartel = ivCartel;
            peliculasAdapterDecorator.txTitulo = txTitulo;
            peliculasAdapterDecorator.txDuracion = txDuracion;
            peliculasAdapterDecorator.txHorario = txHorario;

            convertView.setTag(peliculasAdapterDecorator);
        }

        Pelicula pelicula = listado.get(position);

        PeliculasAdapterDecorator tag = (PeliculasAdapterDecorator) convertView.getTag();

        //((ImageView)convertView.getTag(0)).setImageResource(R.drawable.cartelera);

        tag.ivCartel.setImageResource(R.drawable.cartelera);
        tag.txTitulo.setText(pelicula.getTitulo());
        tag.txDuracion.setText(String.valueOf(pelicula.getDuracion()));
        tag.txHorario.setText(pelicula.getHorario());

        return convertView;
    }

    private class PeliculasAdapterDecorator{
        public ImageView ivCartel;
        public TextView txTitulo;
        public TextView txDuracion;
        public TextView txHorario;
    }

}
