package com.example.profesormanana.contentproviders.modelo.persistencia.sqlite;

import android.database.sqlite.SQLiteDatabase;

import com.example.profesormanana.contentproviders.modelo.entidades.Autor;
import com.example.profesormanana.contentproviders.modelo.persistencia.AutorDao;

import java.util.List;

/**
 * Created by profesormanana on 23/09/15.
 */
public class AutorSQLiteDao implements AutorDao {

    private SQLiteDatabase db;

    public AutorSQLiteDao(SQLiteDatabase db) {
        this.db = db;
    }

    @Override
    public List<Autor> queryAutorByNombre(String nombre) {
        return null;
    }

    @Override
    public void insert(Autor entidad) {

    }

    @Override
    public void update(Autor entidad) {

    }

    @Override
    public void delete(Autor entidad) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Autor> queryAll() {
        return null;
    }

    @Override
    public Autor queryById(int id) {
        return null;
    }
}
