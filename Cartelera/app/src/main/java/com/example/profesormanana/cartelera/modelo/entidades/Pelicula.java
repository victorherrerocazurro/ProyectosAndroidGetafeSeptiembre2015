package com.example.profesormanana.cartelera.modelo.entidades;

/**
 * Created by profesormanana on 15/09/15.
 */
public class Pelicula {

    private String titulo;
    private int duracion;
    private String horario;
    private String genero;

    public Pelicula(int duracion, String titulo, String horario, String genero) {
        this.duracion = duracion;
        this.titulo = titulo;
        this.horario = horario;
        this.genero = genero;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
