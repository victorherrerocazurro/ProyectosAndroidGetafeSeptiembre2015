package com.example.profesormanana.basededatos;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.profesormanana.basededatos.modelo.persistencia.sqlite.AutorSQLiteDao;
import com.example.profesormanana.basededatos.modelo.persistencia.sqlite.NoticiaSQLiteDao;
import com.example.profesormanana.basededatos.modelo.persistencia.sqlite.util.VisualizacionNoticiasSqliteOpenHelper;
import com.example.profesormanana.basededatos.modelo.servicio.NoticiaServicio;
import com.example.profesormanana.basededatos.modelo.servicio.NoticiaServicioImpl;

/**
 * Created by profesormanana on 24/09/15.
 */
public class NoticiasApplication extends Application {

    private NoticiaServicio noticiaServicio;

    public NoticiaServicio getNoticiaServicio() {
        return noticiaServicio;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        VisualizacionNoticiasSqliteOpenHelper sqliteOpenHelper =
                new VisualizacionNoticiasSqliteOpenHelper(this, "noticiasDB", null, 1);

        SQLiteDatabase db = sqliteOpenHelper.getWritableDatabase();

        NoticiaSQLiteDao noticiaSQLiteDao = new NoticiaSQLiteDao(db);

        AutorSQLiteDao autorSQLiteDao = new AutorSQLiteDao(db);

        noticiaServicio = new NoticiaServicioImpl(noticiaSQLiteDao, autorSQLiteDao);

    }
}
