package com.example.profesormanana.clienteserviciorest;
import java.util.Date;


public class Noticia {

	private int id;
    private String titulo;
    private String contenido;
    private Date fecha;

    public Noticia() {
    }

    public Noticia(int id, String titulo, String contenido, Date fecha) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("titulo='").append(titulo).append('\'');
        return sb.toString();
    }
}
