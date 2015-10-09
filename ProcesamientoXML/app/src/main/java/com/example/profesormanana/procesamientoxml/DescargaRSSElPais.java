package com.example.profesormanana.procesamientoxml;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by profesormanana on 28/09/15.
 */
public class DescargaRSSElPais extends AsyncTask<String,Void,List<Noticia>> {

    @Override
    protected List<Noticia> doInBackground(String... params) {

        InputStream is = null;

        try {
            //Fase de descarga

            URL url = new URL(params[0]); //El RSS de Noticias de El Pais

            URLConnection conn = url.openConnection();

            is = conn.getInputStream();

            //Fase de transformacion

            return transformarSAX(is);
            //return transformarXMLPullParser(is, conn.getContentEncoding());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Noticia> transformarSAX(InputStream is) throws SAXException, IOException {

        XMLReader parser = XMLReaderFactory.createXMLReader();

        NoticiasElPaisContentHandler handler = new NoticiasElPaisContentHandler();

        parser.setContentHandler(handler);

        parser.parse(new InputSource(is));

        //En este punto sabemos que el List esta relleno con todas las noticias leidas

        return handler.getNoticias();
    }

    private List<Noticia> transformarXMLPullParser(InputStream is, String contentEncoding) throws XmlPullParserException, IOException {

        //Mon, 28 Sep 2015 10:51:10 +0200
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");

        List<Noticia> resultado = new LinkedList<>();

        XmlPullParser parser = Xml.newPullParser();

        parser.setInput(is, contentEncoding);

        int event = parser.getEventType();

        Noticia item = null;

        while(event != XmlPullParser.END_DOCUMENT) {

            if(event == XmlPullParser.START_TAG){
                if(parser.getName().equals("item")){
                    item = new Noticia();
                } else if(item != null) {
                    switch (parser.getName()) {
                        case "title":
                            item.setTitulo(parser.nextText());
                            break;
                        case "guid":
                            item.setGuid(parser.nextText());
                            break;
                        case "dc:creator":
                            item.setAutor(parser.nextText());
                            break;
                        case "pubDate":
                            try {
                                item.setFecha(sdf.parse(parser.nextText()));
                            } catch (ParseException e) {
                                //e.printStackTrace();
                                Log.e(this.getClass().getName(), e.getMessage());
                                //Para para el proceso
                                //throw new SAXException(e);
                                item.setFecha(null);
                            }
                            break;
                        case "content:encoded":
                            item.setContenido(parser.nextText());
                            break;
                    }
                }
            } else if(event == XmlPullParser.END_TAG && parser.getName().equals("item")){
                resultado.add(item);
                item = null;
            }

            event = parser.next();
        }

        return resultado;
    }

}
