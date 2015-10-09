package com.example.profesormanana.basededatos.modelo.persistencia;

import com.example.profesormanana.basededatos.modelo.entidades.Autor;
import com.example.profesormanana.basededatos.modelo.entidades.Noticia;

import java.util.Arrays;
import java.util.List;

/**
 * Created by profesormanana on 23/09/15.
 */
public interface AutorDao extends Dao<Autor> {
    List<Autor> queryAutorByNombre(String nombre);
}
