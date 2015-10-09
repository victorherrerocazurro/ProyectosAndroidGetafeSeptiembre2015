package com.example.profesormanana.contentproviders.modelo.entidades;

import java.util.List;

/**
 * Created by profesormanana on 23/09/15.
 */
public class Autor {
    private int id;
    private String nombre;
    private List<Noticia> Noticias;

    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Noticia> getNoticias() {
        return Noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        Noticias = noticias;
    }
}
