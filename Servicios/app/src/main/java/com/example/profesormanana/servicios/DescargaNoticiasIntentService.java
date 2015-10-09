package com.example.profesormanana.servicios;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import com.example.profesormanana.servicios.persistencia.sqlite.NoticiaSQLiteDao;
import com.example.profesormanana.servicios.persistencia.sqlite.util.VisualizacionNoticiasSqliteOpenHelper;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class DescargaNoticiasIntentService extends IntentService {

    private  static final int NOTIFICACION_INICIAL = 0;
    private  static final int NOTIFICACION_FINAL = 1;
    public static final int NOTIFICATION_DESCARGA_NOTICIAS_ID = 123456;

    private Notification.Builder builderInicio;
    private Notification.Builder builderFin;
    private NotificationManager notificationManager;

    public DescargaNoticiasIntentService() {
        super("DescargaNoticiasIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        builderInicio = new Notification.Builder(this);

        builderInicio
                .setTicker("Descargando Noticias")
                .setSmallIcon(android.R.drawable.ic_menu_upload)
                .setProgress(0, 0, true)
                .setContentTitle("Descargando Noticias del feed RSS de El Pais")
                .setAutoCancel(false);

        builderFin = new Notification.Builder(this);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builderFin
                .setTicker("Noticias descargadas")
                .setSmallIcon(android.R.drawable.ic_menu_upload)
                .setContentTitle("Noticias descargadas del feed RSS de El Pais")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String url = "http://ep00.epimg.net/rss/elpais/portada.xml";
        try(InputStream is = descargaNoticias(url)) {

            mostrarNotificacion(NOTIFICACION_INICIAL);

            List<Noticia> noticias = transformarSAX(is);

            persistirEnBaseDeDatos(noticias);

            Thread.sleep(3000);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mostrarNotificacion(NOTIFICACION_FINAL);

            //Intent intentBroadcast = new Intent(this, MiBroadcastReceiver.class);
            Intent intentBroadcast = new Intent("com.example.profesormanana.servicios.BROADCAST");
            sendBroadcast(intentBroadcast);
        }
    }

    private void mostrarNotificacion(int tipo) {
        switch (tipo){
            case NOTIFICACION_INICIAL:
                notificationManager.notify(NOTIFICATION_DESCARGA_NOTICIAS_ID, builderInicio.build());
                break;
            case NOTIFICACION_FINAL:
                notificationManager.notify(NOTIFICATION_DESCARGA_NOTICIAS_ID, builderFin.build());
                break;
        }
    }

    private InputStream descargaNoticias(String sUrl) throws IOException {
        URL url = new URL(sUrl);

        URLConnection conn = url.openConnection();

        return conn.getInputStream();
    }

    private List<Noticia> transformarSAX(InputStream is) throws SAXException, IOException {

        System.setProperty("org.xml.sax.driver","org.xmlpull.v1.sax2.Driver");

        XMLReader parser = XMLReaderFactory.createXMLReader();

        NoticiasElPaisContentHandler handler = new NoticiasElPaisContentHandler();

        parser.setContentHandler(handler);

        parser.parse(new InputSource(is));

        //En este punto sabemos que el List esta relleno con todas las noticias leidas

        return handler.getNoticias();
    }

    private void persistirEnBaseDeDatos(List<Noticia> listado){
        VisualizacionNoticiasSqliteOpenHelper sqliteOpenHelper =
                new VisualizacionNoticiasSqliteOpenHelper(this, "noticiasDB", null, 1);

        SQLiteDatabase db = sqliteOpenHelper.getWritableDatabase();

        NoticiaSQLiteDao noticiaSQLiteDao = new NoticiaSQLiteDao(db);

        /*for (Noticia noticia: listado) {
            noticiaSQLiteDao.insert(noticia);
        }*/

        noticiaSQLiteDao.insert(listado.get(0));
    }
}
