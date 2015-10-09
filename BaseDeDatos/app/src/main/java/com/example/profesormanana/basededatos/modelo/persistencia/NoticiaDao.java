package com.example.profesormanana.basededatos.modelo.persistencia;

import com.example.profesormanana.basededatos.modelo.entidades.Noticia;

import java.util.Date;
import java.util.List;

/**
 * Created by profesormanana on 23/09/15.
 */
public interface NoticiaDao extends Dao<Noticia>{
    List<Noticia> queryNoticiaByTitulo(String titulo);
}
