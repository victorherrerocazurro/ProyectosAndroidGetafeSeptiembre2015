package com.example.profesormanana.fragmentos;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by profesormanana on 29/09/15.
 */
public class CorreoElectronico implements Serializable {

    private String asunto;
    private String remitente;
    private String destinatario;
    private String contenido;
    private Date fechaEnvio;
    private Date fechaEntrega;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CorreoElectronico{");
        sb.append("asunto='").append(asunto).append('\'');
        sb.append(", remitente='").append(remitente).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public CorreoElectronico() {
    }

    public CorreoElectronico(String asunto, String remitente, String destinatario, String contenido, Date fechaEnvio, Date fechaEntrega) {
        this.asunto = asunto;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
        this.fechaEntrega = fechaEntrega;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
