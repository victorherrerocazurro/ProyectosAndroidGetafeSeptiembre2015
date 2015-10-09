package com.example.profesormanana.procesamientoxml;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

/**
 * Created by profesormanana on 28/09/15.
 */
public class NoticiasElPaisContentHandler extends DefaultHandler {

    private LinkedList<Noticia> noticias;

    public LinkedList<Noticia> getNoticias() {
        return noticias;
    }

    private Noticia item;
    private StringBuilder sb;
    //Mon, 28 Sep 2015 10:51:10 +0200
    private SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        //Prepararemos los objetos necesarios para realizar el parseo

        noticias = new LinkedList<>();
        sb = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //Preparar objetos y leer atributos de etiquetas

        sb.setLength(0);

        if(localName.equals("item")){
           item = new Noticia();
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        //Acumular los caracteres entre las etiquetas de inicio y de fin
        sb.append(ch,start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        //Establecer los valores a las caracteristicas de los objetos

        if(localName.equals("item")){
            //Tengo que insertar un objeto noticia en la lista
            noticias.add(item);
            item = null;
        } else if(item != null && localName.equals("title")){
            item.setTitulo(sb.toString());
        } else if(item != null && localName.equals("guid")){
            item.setGuid(sb.toString());
        } else if(item != null && localName.equals("dc:creator")){
            item.setAutor(sb.toString());
        } else if(item != null && localName.equals("pubDate")){
            try {
                item.setFecha(sdf.parse(sb.toString()));
            } catch (ParseException e) {
                //e.printStackTrace();
                Log.e(this.getClass().getName(), e.getMessage());
                //Para para el proceso
                //throw new SAXException(e);
                item.setFecha(null);
            }
        } else if(item != null && localName.equals("content:encoded")){
            item.setContenido(sb.toString());
        }

    }
}
