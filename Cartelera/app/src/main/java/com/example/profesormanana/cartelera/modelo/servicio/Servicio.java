package com.example.profesormanana.cartelera.modelo.servicio;

import com.example.profesormanana.cartelera.modelo.entidades.Pelicula;

import java.util.List;

/**
 * Created by profesormanana on 15/09/15.
 */
public interface Servicio {
    List<Pelicula> getTodasPeliculas();
}
