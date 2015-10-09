package com.example.profesormanana.menucontextual.modelo.servicio;

import com.example.profesormanana.menucontextual.modelo.entidades.Pelicula;
import com.example.profesormanana.menucontextual.modelo.negocio.Negocio;

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

    @Override
    public Pelicula getPeliculaById(int position) {
        return this.negocio.getPeliculaById(position);
    }

    @Override
    public void removePeliculaById(int position) {
        this.negocio.removePeliculaById(position);
    }

    @Override
    public void updatePelicula(int posicion, Pelicula peliculaModificada) {
        this.negocio.updatePelicula(posicion, peliculaModificada);
    }
}
