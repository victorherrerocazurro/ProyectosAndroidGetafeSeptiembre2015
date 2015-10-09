package com.example.profesormanana.contentproviders.modelo.servicio;

import com.example.profesormanana.contentproviders.modelo.entidades.Autor;
import com.example.profesormanana.contentproviders.modelo.entidades.Noticia;
import com.example.profesormanana.contentproviders.modelo.persistencia.AutorDao;
import com.example.profesormanana.contentproviders.modelo.persistencia.NoticiaDao;

import java.util.List;

/**
 * Created by profesormanana on 24/09/15.
 */
public class NoticiaServicioImpl implements NoticiaServicio {

    private NoticiaDao noticiaDao;
    private AutorDao autorDao;

    public NoticiaServicioImpl(NoticiaDao noticiaDao, AutorDao autorDao) {
        this.noticiaDao = noticiaDao;
        this.autorDao = autorDao;
    }

    @Override
    public void altaNoticia(Noticia noticia) {
        noticiaDao.insert(noticia);

        if(noticia.getAutor() != null) {
            List<Autor> autores = autorDao.queryAutorByNombre(noticia.getAutor().getNombre());

            if (autores != null && autores.size() <= 0) {
                autorDao.insert(noticia.getAutor());
            }
        }
    }

    @Override
    public List<Noticia> dameTodasLasNoticias() {
        return noticiaDao.queryAll();
    }
}
