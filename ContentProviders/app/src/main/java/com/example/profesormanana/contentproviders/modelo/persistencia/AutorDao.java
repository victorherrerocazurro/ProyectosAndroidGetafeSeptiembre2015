package com.example.profesormanana.contentproviders.modelo.persistencia;

import com.example.profesormanana.contentproviders.modelo.entidades.Autor;

import java.util.List;

/**
 * Created by profesormanana on 23/09/15.
 */
public interface AutorDao extends Dao<Autor> {
    List<Autor> queryAutorByNombre(String nombre);
}
