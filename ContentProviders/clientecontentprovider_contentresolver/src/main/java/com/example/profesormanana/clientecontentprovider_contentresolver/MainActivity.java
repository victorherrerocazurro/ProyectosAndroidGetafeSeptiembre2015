package com.example.profesormanana.clientecontentprovider_contentresolver;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.profesormanana.contentproviders.modelo.entidades.Noticia;
import com.example.profesormanana.contentproviders.modelo.servicio.NoticiasContentProviderUtil;

import java.text.ParseException;
import java.util.Date;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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

            ContentValues values = new ContentValues();

            values.put(Noticia.NOTICIA_CAMPO_TITULO, "Extra Extra!!!");
            values.put(Noticia.NOTICIA_CAMPO_CONTENIDO, "La mayor noticia jamas contada en este diario");
            values.put(Noticia.NOTICIA_CAMPO_FECHA, "2015-10-07");

            Uri uri = getContentResolver().insert(
                    Uri.withAppendedPath(
                            NoticiasContentProviderUtil.URI_AUTHORITY,
                            Noticia.TABLA_NOTICIA)
                    ,
                    values);

            Cursor cursor = getContentResolver().query(uri, null, null, null, null);

            if(cursor.moveToFirst()) {
                do {

                    Toast.makeText(MainActivity.this,
                            "ID=" + cursor.getInt(cursor.getColumnIndex(Noticia.NOTICIA_CAMPO_ID)) +
                                    "TITULO=" + cursor.getString(cursor.getColumnIndex(Noticia.NOTICIA_CAMPO_TITULO)) +
                                    "CONTENIDO=" + cursor.getString(cursor.getColumnIndex(Noticia.NOTICIA_CAMPO_CONTENIDO)) +
                                    "FECHA=" + cursor.getString(cursor.getColumnIndex(Noticia.NOTICIA_CAMPO_FECHA))
                            , Toast.LENGTH_SHORT).show();

                } while (cursor.moveToNext());
            }

            Cursor cursorListado = getContentResolver().query(Uri.withAppendedPath(
                    NoticiasContentProviderUtil.URI_AUTHORITY,
                    Noticia.TABLA_NOTICIA), null, null, null, null);

            if(cursorListado.moveToFirst()) {
                do {

                    Toast.makeText(MainActivity.this,
                            "ID=" + cursorListado.getInt(cursorListado.getColumnIndex(Noticia.NOTICIA_CAMPO_ID)) +
                                    "TITULO=" + cursorListado.getString(cursorListado.getColumnIndex(Noticia.NOTICIA_CAMPO_TITULO)) +
                                    "CONTENIDO=" + cursorListado.getString(cursorListado.getColumnIndex(Noticia.NOTICIA_CAMPO_CONTENIDO)) +
                                    "FECHA=" + cursorListado.getString(cursorListado.getColumnIndex(Noticia.NOTICIA_CAMPO_FECHA))
                            , Toast.LENGTH_SHORT).show();

                } while (cursorListado.moveToNext());
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
