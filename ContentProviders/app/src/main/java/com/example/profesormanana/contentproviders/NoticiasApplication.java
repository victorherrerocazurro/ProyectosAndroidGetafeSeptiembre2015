package com.example.profesormanana.contentproviders;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.profesormanana.contentproviders.modelo.persistencia.sqlite.AutorSQLiteDao;
import com.example.profesormanana.contentproviders.modelo.persistencia.sqlite.NoticiaSQLiteDao;
import com.example.profesormanana.contentproviders.modelo.persistencia.sqlite.util.VisualizacionNoticiasSqliteOpenHelper;
import com.example.profesormanana.contentproviders.modelo.servicio.NoticiaServicio;
import com.example.profesormanana.contentproviders.modelo.servicio.NoticiaServicioImpl;

/**
 * Created by profesormanana on 24/09/15.
 */
public class NoticiasApplication extends Application {

    public NoticiasApplication() {
    }

    private NoticiaServicio noticiaServicio;
    private SQLiteDatabase db;

    public SQLiteDatabase getDb() {
        return db;
    }

    public NoticiaServicio getNoticiaServicio() {
        return noticiaServicio;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        VisualizacionNoticiasSqliteOpenHelper sqliteOpenHelper =
                new VisualizacionNoticiasSqliteOpenHelper(this, "noticiasDB", null, 1);

        db = sqliteOpenHelper.getWritableDatabase();

        NoticiaSQLiteDao noticiaSQLiteDao = new NoticiaSQLiteDao(db);

        AutorSQLiteDao autorSQLiteDao = new AutorSQLiteDao(db);

        noticiaServicio = new NoticiaServicioImpl(noticiaSQLiteDao, autorSQLiteDao);

    }
}
