package com.example.profesormanana.ficheros;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {

    private EditText etDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDato = (EditText) findViewById(R.id.etDato);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_leer_res) {

            //El recurso "pasado por parametros" al try debe ser autoclosable
            try(InputStream is = getResources().openRawResource(R.raw.prueba)){

                InputStreamReader isr = new InputStreamReader(is);

                BufferedReader br = new BufferedReader(isr);

                String s = br.readLine();

                Toast.makeText(MainActivity.this, "El texto leido de Raw es: " + s, Toast.LENGTH_LONG).show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (id == R.id.action_escribir_memoria_interna) {

            try(FileOutputStream fos = openFileOutput("mi_fichero.txt", MODE_PRIVATE)) {
                OutputStreamWriter osw = new OutputStreamWriter(fos);

                osw.write(etDato.getText().toString());

                osw.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (id == R.id.action_leer_memoria_interna) {

            //El recurso "pasado por parametros" al try debe ser autoclosable
            try(InputStream is = openFileInput("mi_fichero.txt")){

                InputStreamReader isr = new InputStreamReader(is);

                BufferedReader br = new BufferedReader(isr);

                String s = br.readLine();

                Toast.makeText(MainActivity.this, "El texto leido de Memoria Interna es: " + s, Toast.LENGTH_LONG).show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (id == R.id.action_escribir_memoria_sd) {

            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){

                File directory = Environment.getExternalStorageDirectory();//PublicDirectory(Environment.DIRECTORY_DOCUMENTS);

                if (directory.mkdirs() || directory.isDirectory()){
                    //Tenemos la garantia de que el directorio existe

                    File file = new File(directory, "mi_fichero.txt");

                    try(FileOutputStream fos = new FileOutputStream(file)) {

                        OutputStreamWriter osw = new OutputStreamWriter(fos);

                        osw.write(etDato.getText().toString());

                        osw.flush();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "El directorio no se ha podido crear", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(MainActivity.this, "No se puede escribir en la tarjeta externa", Toast.LENGTH_LONG).show();
            }

        } else if (id == R.id.action_leer_memoria_sd) {
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)
                    || Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED_READ_ONLY)){

                File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

                if (directory.isDirectory()){

                    File file = new File(directory, "mi_fichero.txt");

                    try(FileInputStream is = new FileInputStream(file)) {

                        InputStreamReader isr = new InputStreamReader(is);

                        BufferedReader br = new BufferedReader(isr);

                        String s = br.readLine();

                        Toast.makeText(MainActivity.this, "El texto leido de SD es: " + s, Toast.LENGTH_LONG).show();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "El recurso a leer no existe en la ruta especificada", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(MainActivity.this, "No se puede leer la tarjeta externa", Toast.LENGTH_LONG).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
