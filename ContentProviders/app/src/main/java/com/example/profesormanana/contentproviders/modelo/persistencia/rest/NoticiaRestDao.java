package com.example.profesormanana.contentproviders.modelo.persistencia.rest;

import com.example.profesormanana.contentproviders.modelo.entidades.Noticia;
import com.example.profesormanana.contentproviders.modelo.persistencia.NoticiaDao;

import java.util.List;

/**
 * Created by profesormanana on 23/09/15.
 */
public class NoticiaRestDao implements NoticiaDao {
    @Override
    public List<Noticia> queryNoticiaByTitulo(String titulo) {
        return null;
    }

    @Override
    public void insert(Noticia entidad) {

    }

    @Override
    public void update(Noticia entidad) {

    }

    @Override
    public void delete(Noticia entidad) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Noticia> queryAll() {
        return null;
    }

    @Override
    public Noticia queryById(int id) {
        return null;
    }
}
