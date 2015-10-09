package com.example.profesormanana.cartelera.modelo.negocio;

import com.example.profesormanana.cartelera.modelo.entidades.Pelicula;
import com.example.profesormanana.cartelera.modelo.persistencia.Persistencia;

import java.util.List;

/**
 * Created by profesormanana on 15/09/15.
 */
public class Negocio {
    private Persistencia persistencia;

    public Negocio(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public List<Pelicula> getPeliculas() {
        return
                this.persistencia.getPeliculas();
    }
}
