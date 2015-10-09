package com.example.profesormanana.cartelera.modelo.servicio;

import com.example.profesormanana.cartelera.modelo.entidades.Pelicula;
import com.example.profesormanana.cartelera.modelo.negocio.Negocio;
import com.example.profesormanana.cartelera.modelo.servicio.Servicio;

import java.util.List;

/**
 * Created by profesormanana on 15/09/15.
 */
public class ServicioImpl implements Servicio {
    private Negocio negocio;

    public ServicioImpl(Negocio negocio) {
        this.negocio = negocio;
    }

    @Override
    public List<Pelicula> getTodasPeliculas() {
        return this.negocio.getPeliculas();
    }
}
