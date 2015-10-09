package com.example.profesormanana.descargaimagen;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

/**
 * Created by profesormanana on 22/09/15.
 */
public class DescargaImagenAsyncTask extends AsyncTask<String,Integer,Bitmap> {

    private Context context;
    private ProgressDialog dialogo;
    private ImageView imageView;

    public DescargaImagenAsyncTask(ProgressDialog dialogo, ImageView imageView, Context context) {
        this.dialogo = dialogo;
        this.imageView = imageView;
        this.context = context;
    }

    //Metodo que se ejecuta en otro hilo

    @Override
    protected Bitmap doInBackground(String... params) {

        String stringUrl = params[0];//http://www.google.es/imagen.png

        try {
            URL url = new URL(stringUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            //Para PUT y POST

            /*OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());

            osw.write("{JSON}");

            connection.connect();*/

            InputStream is = connection.getInputStream();

            int tamano = connection.getContentLength();

            byte[] buffer = new byte[10];

            byte[] imagen = new byte[tamano];

            int bytesLeidos = 0;

            for (int i = is.read(buffer); i != -1; i = is.read(buffer)){

                System.arraycopy(buffer, 0, imagen, bytesLeidos, i);

                bytesLeidos += i;

                publishProgress(bytesLeidos * 100 / tamano);

            }

            return BitmapFactory.decodeByteArray(imagen,0,tamano);
            //return BitmapFactory.decodeStream(is);

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        //publishProgress(10);

        return null;

    }

    //Antes de Ejecutar la tarea

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialogo.setProgress(0);
        dialogo.setMax(100);
        dialogo.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialogo.show();
    }

    //Despues de ejecutar la tarea

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        if(bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            Toast.makeText(context, "Ha habido un error", Toast.LENGTH_LONG).show();
        }
        dialogo.hide();
    }

    //Durante la ejecucion dela tarea, al invocar el publishProgress

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        dialogo.setProgress(values[0]);
    }
}
