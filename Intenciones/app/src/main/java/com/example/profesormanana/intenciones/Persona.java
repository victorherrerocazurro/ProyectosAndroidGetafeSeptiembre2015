package com.example.profesormanana.intenciones;

import java.io.Serializable;

/**
 * Created by profesormanana on 16/09/15.
 */
public class Persona implements Serializable{
    private String nombre;
    private String apellido;

    public Persona() {
    }

    public Persona(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
