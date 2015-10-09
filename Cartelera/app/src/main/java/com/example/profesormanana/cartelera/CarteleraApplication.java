package com.example.profesormanana.cartelera;

import android.app.Application;

import com.example.profesormanana.cartelera.modelo.negocio.Negocio;
import com.example.profesormanana.cartelera.modelo.persistencia.Persistencia;
import com.example.profesormanana.cartelera.modelo.servicio.Servicio;
import com.example.profesormanana.cartelera.modelo.servicio.ServicioImpl;

/**
 * Created by profesormanana on 15/09/15.
 */
public class CarteleraApplication extends Application {

    private Servicio servicio;

    @Override
    public void onCreate() {
        super.onCreate();

        Persistencia persistencia = new Persistencia();

        Negocio negocio = new Negocio(persistencia);

        this.servicio = new ServicioImpl(negocio);

    }

    public Servicio getServicio(){
        return this.servicio;
    }
}
