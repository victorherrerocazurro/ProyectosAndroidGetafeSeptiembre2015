package com.example.profesormanana.contentproviders.modelo.persistencia;

import com.example.profesormanana.contentproviders.modelo.entidades.Noticia;

import java.util.List;

/**
 * Created by profesormanana on 23/09/15.
 */
public interface NoticiaDao extends Dao<Noticia>{
    List<Noticia> queryNoticiaByTitulo(String titulo);
}
