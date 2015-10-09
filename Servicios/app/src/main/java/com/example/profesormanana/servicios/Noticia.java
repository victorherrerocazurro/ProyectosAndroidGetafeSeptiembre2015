package com.example.profesormanana.servicios;

import java.util.Date;

/**
 * Created by profesormanana on 28/09/15.
 */
public class Noticia {

    public static final String TABLA_NOTICIA = "Noticia";
    public static final String NOTICIA_CAMPO_ID = "id";
    public static final String NOTICIA_CAMPO_TITULO = "titulo";
    public static final String NOTICIA_CAMPO_CONTENIDO = "contenido";
    public static final String NOTICIA_CAMPO_FECHA = "fecha";
    public static final String NOTICIA_CAMPO_GUID = "guid";
    public static final String NOTICIA_CAMPO_AUTOR = "autor";

    private int id;
    private String guid; //PK
    private String titulo;
    private String autor;
    private Date fecha;
    private String contenido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
