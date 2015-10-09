package com.example.profesormanana.basededatos.modelo.servicio;

import com.example.profesormanana.basededatos.modelo.entidades.Noticia;

import java.util.List;

/**
 * Created by profesormanana on 24/09/15.
 */
public interface NoticiaServicio {

    void altaNoticia(Noticia noticia);

    List<Noticia> dameTodasLasNoticias();

}
