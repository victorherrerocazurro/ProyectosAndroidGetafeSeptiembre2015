package com.example.profesormanana.explicacionapplication;

import android.app.Application;

/**
 * Created by profesormanana on 11/09/15.
 */
public class MiApplication extends Application {

    private Negocio negocio;

    @Override
    public void onCreate() {
        super.onCreate();

        //Instanciamos todos los objetos de logica y favorecemos la inyeccion
        negocio = new Negocio(new Persistencia());

    }

    public Negocio getNegocio() {
        return negocio;
    }
}
