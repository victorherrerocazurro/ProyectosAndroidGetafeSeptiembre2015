package com.example.profesormanana.basededatos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.profesormanana.basededatos.modelo.entidades.Noticia;
import com.example.profesormanana.basededatos.modelo.servicio.NoticiaServicio;

import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {

    private NoticiaServicio noticiaServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noticiaServicio = ((NoticiasApplication)getApplicationContext()).getNoticiaServicio();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Noticia noticia = new Noticia("Extra!! Extra!!", "La mayor noticia del siglo", new Date(),null);

            noticiaServicio.altaNoticia(noticia);

            List<Noticia> noticias = noticiaServicio.dameTodasLasNoticias();

            Toast.makeText(this, "Noticias" + noticias, Toast.LENGTH_SHORT).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
