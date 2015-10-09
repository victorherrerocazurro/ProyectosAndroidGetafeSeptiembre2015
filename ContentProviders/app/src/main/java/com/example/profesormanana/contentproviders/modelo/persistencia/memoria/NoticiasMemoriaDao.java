package com.example.profesormanana.contentproviders.modelo.persistencia.memoria;

import com.example.profesormanana.contentproviders.modelo.entidades.Noticia;
import com.example.profesormanana.contentproviders.modelo.persistencia.NoticiaDao;

import java.util.List;

/**
 * Created by profesormanana on 30/09/15.
 */
public class NoticiasMemoriaDao implements NoticiaDao {
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
