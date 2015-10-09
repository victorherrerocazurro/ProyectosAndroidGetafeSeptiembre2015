package com.example.profesormanana.descargaimagen;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView imageView;
    private ProgressDialog dialogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        dialogo = new ProgressDialog(this);
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

            //Lanzar la tarea asincrona
            DescargaImagenAsyncTask asyncTask = new DescargaImagenAsyncTask(dialogo, imageView, this);

            asyncTask.execute("http://www.blogcdn.com/es.autoblog.com/media/2012/09/01-mclaren-p1-paris.jpg");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
