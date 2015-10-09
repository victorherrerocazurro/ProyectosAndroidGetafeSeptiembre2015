package com.example.profesormanana.menucontextual.modelo.persistencia;

import com.example.profesormanana.menucontextual.modelo.entidades.Pelicula;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by profesormanana on 15/09/15.
 */
public class Persistencia {
    private List<Pelicula> peliculas;

    public Persistencia() {
        this.peliculas = new ArrayList<>();

        peliculas.add(new Pelicula(120,"Lo que el viento se llevo","18:00 20:00 22:00", "Drama"));
        peliculas.add(new Pelicula(120,"Casablanca","18:00 20:00 22:00", "Drama"));
        peliculas.add(new Pelicula(120,"Mad Max","18:00 20:00 22:00", "Ciencia Ficcion"));
        peliculas.add(new Pelicula(120,"Rec","18:00 20:00 22:00", "Terror"));
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public Pelicula getPeliculaById(int position) {
        return peliculas.get(position);
    }

    public void removePeliculaById(int position){
        peliculas.remove(position);
    }

    public void updatePelicula(int posicion, Pelicula peliculaModificada) {
        peliculas.set(posicion,peliculaModificada);
    }
}
