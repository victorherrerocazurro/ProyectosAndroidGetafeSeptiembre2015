package com.example.profesormanana.menucontextual.modelo.servicio;

import com.example.profesormanana.menucontextual.modelo.entidades.Pelicula;

import java.util.List;

/**
 * Created by profesormanana on 15/09/15.
 */
public interface Servicio {
    List<Pelicula> getTodasPeliculas();
    Pelicula getPeliculaById(int position);

    void removePeliculaById(int position);

    void updatePelicula(int posicion, Pelicula peliculaModificada);
}
