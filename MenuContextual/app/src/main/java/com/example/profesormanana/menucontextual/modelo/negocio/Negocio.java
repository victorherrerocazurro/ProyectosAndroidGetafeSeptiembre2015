package com.example.profesormanana.menucontextual.modelo.negocio;

import com.example.profesormanana.menucontextual.modelo.entidades.Pelicula;
import com.example.profesormanana.menucontextual.modelo.persistencia.Persistencia;

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

    public Pelicula getPeliculaById(int position) {
        return this.persistencia.getPeliculaById(position);
    }

    public void removePeliculaById(int position) {
        this.persistencia.removePeliculaById(position);
    }

    public void updatePelicula(int posicion, Pelicula peliculaModificada) {
        this.persistencia.updatePelicula(posicion,peliculaModificada);
    }
}
