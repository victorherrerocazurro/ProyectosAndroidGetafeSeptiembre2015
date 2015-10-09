package com.example.profesormanana.clienteserviciorest;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by profesormanana on 01/10/15.
 */
public class ConexionServidorRemotoAsyncTask extends AsyncTask<String, Void, Void> {


    @Override
    protected Void doInBackground(String... params) {

        try {
            URL url = new URL(params[0]);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            connection.connect();

            InputStream is = connection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String tmp = br.readLine();
            String resultadoLectura = "";


            while (tmp != null){

                resultadoLectura += tmp;

                tmp = br.readLine();
            };

            JSONObject json = new JSONObject(resultadoLectura);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sssZ");

            Noticia noticia = new Noticia(
                    json.getInt("id"),
                    json.getString("titulo"),
                    json.getString("contenido"),
                    sdf.parse(json.getString("fecha")));

            Log.i(this.getClass().getName(), "La noticia: " + noticia);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "ERROR: " + e.getMessage());
        }

        return null;
    }
}
