package com.example.profesormanana.basededatos.modelo.persistencia.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.profesormanana.basededatos.modelo.entidades.Noticia;
import com.example.profesormanana.basededatos.modelo.persistencia.NoticiaDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by profesormanana on 23/09/15.
 */
public class NoticiaSQLiteDao implements NoticiaDao {

    public static final String TABLA_NOTICIA = "Noticia";
    public static final String NOTICIA_CAMPO_ID = "id";
    public static final String NOTICIA_CAMPO_TITULO = "titulo";
    public static final String NOTICIA_CAMPO_CONTENIDO = "contenido";
    public static final String NOTICIA_CAMPO_FECHA = "fecha";

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private SQLiteDatabase db;

    public NoticiaSQLiteDao(SQLiteDatabase db) {
        this.db = db;
    }

    @Override
    public void insert(Noticia entidad) {
        long idAutogenerado = db.insert(TABLA_NOTICIA, NOTICIA_CAMPO_ID, noticiaToContentValues(entidad));

        entidad.setId((int) idAutogenerado);
    }

    @Override
    public void update(Noticia entidad) {

        String whereClause = NOTICIA_CAMPO_ID + " = ?";
        String[] whereArgs = {String.valueOf(entidad.getId())};

        db.update(TABLA_NOTICIA, noticiaToContentValues(entidad), whereClause, whereArgs);
    }

    @Override
    public void delete(Noticia entidad) {
        delete(entidad.getId());
    }

    @Override
    public void delete(int id) {
        String whereClause = NOTICIA_CAMPO_ID + " = ?";
        String[] whereArgs = {String.valueOf(id)};

        db.delete(TABLA_NOTICIA, whereClause, whereArgs);
    }

    @Override
    public List<Noticia> queryAll() {
        return queryWithWhere(null, null);
    }

    @Override
    public Noticia queryById(int id) {

        String whereClause = NOTICIA_CAMPO_ID + " = ?";
        String[] whereArgs = {String.valueOf(id)};

        Cursor cursor = db.query(TABLA_NOTICIA, null, whereClause, whereArgs, null, null, null);

        if(cursor.moveToFirst()) {
            Noticia noticia = cursorToNoticia(cursor);
            return  noticia;
        }

        return null;
    }

    @Override
    public List<Noticia> queryNoticiaByTitulo(String titulo) {

        String whereClause = NOTICIA_CAMPO_TITULO + " = ?";
        String[] whereArgs = {titulo};

        return queryWithWhere(whereClause, whereArgs);
    }

    private List<Noticia> queryWithWhere(String whereClause, String[] whereArgs) {
        LinkedList<Noticia> resultado = new LinkedList<>();

        Cursor cursor = db.query(TABLA_NOTICIA, null, whereClause, whereArgs, null, null, null);

        if(cursor.moveToFirst()) {
            do {

                Noticia noticia = cursorToNoticia(cursor);

                resultado.add(noticia);

            } while (cursor.moveToNext());
        }

        return resultado;
    }

    private Noticia cursorToNoticia(Cursor cursor) {
        Noticia noticia = new Noticia();

        noticia.setId(cursor.getInt(cursor.getColumnIndex(NOTICIA_CAMPO_ID)));
        noticia.setTitulo(cursor.getString(cursor.getColumnIndex(NOTICIA_CAMPO_TITULO)));
        noticia.setContenido(cursor.getString(cursor.getColumnIndex(NOTICIA_CAMPO_CONTENIDO)));

        try {
            noticia.setFecha(sdf.parse(cursor.getString(cursor.getColumnIndex(NOTICIA_CAMPO_FECHA))));
        } catch (ParseException e) {
            noticia.setFecha(null);
            e.printStackTrace();
        }
        return noticia;
    }

    private ContentValues noticiaToContentValues(Noticia entidad) {
        ContentValues noticiaContentValues = new ContentValues();

        //noticiaContentValues.put(NOTICIA_CAMPO_ID,entidad.getId());
        noticiaContentValues.put(NOTICIA_CAMPO_TITULO,entidad.getTitulo());
        noticiaContentValues.put(NOTICIA_CAMPO_CONTENIDO,entidad.getContenido());
        noticiaContentValues.put(NOTICIA_CAMPO_FECHA,sdf.format(entidad.getFecha()));
        return noticiaContentValues;
    }
}
