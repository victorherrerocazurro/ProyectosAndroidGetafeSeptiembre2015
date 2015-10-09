package com.example.profesormanana.contentproviders.modelo.servicio;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.profesormanana.contentproviders.NoticiasApplication;
import com.example.profesormanana.contentproviders.modelo.entidades.Noticia;

public class NoticiasContentProvider extends ContentProvider {

    //Method HTTP = metodo de clase ContentProvider
    //ContentValues = Cuerpo de la petición
    //URI AUTHORITY = host
    //PATH = PATH

    private static UriMatcher uriMatcher;

    private static final int CODE_NOTICIAS = 0;
    private static final int CODE_NOTICIA = 1;
    private static final int CODE_AUTORES = 2;
    private static final int CODE_AUTOR = 3;

    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(NoticiasContentProviderUtil.AUTHORITY, Noticia.TABLA_NOTICIA, CODE_NOTICIAS);
        uriMatcher.addURI(NoticiasContentProviderUtil.AUTHORITY, Noticia.TABLA_NOTICIA + "/#", CODE_NOTICIA);
        uriMatcher.addURI(NoticiasContentProviderUtil.AUTHORITY, "Autor", CODE_AUTORES);
        uriMatcher.addURI(NoticiasContentProviderUtil.AUTHORITY, "Autor" + "/#", CODE_AUTOR);
    }

    //Construtor mandatory
    public NoticiasContentProvider() {
    }

    @Override
    public boolean onCreate() {
        return true;
    }

    //content://com.example.profesormanana.com.example.profesormanana.contentproviders/Noticia/1
    //o TAMBIEN PODIAMOS ESCOGER ESTA URI
    //content://com.example.profesormanana.com.example.profesormanana.contentproviders/Noticia

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        switch(uriMatcher.match(uri)){
            case CODE_NOTICIA:
                selection = Noticia.NOTICIA_CAMPO_ID + " = ?";
                selectionArgs = new String[]{uri.getLastPathSegment()};
                return ((NoticiasApplication)getContext()).getDb().delete(Noticia.TABLA_NOTICIA, selection, selectionArgs);
            case CODE_AUTOR:
                selection = "id_autor" + " = ?";
                selectionArgs = new String[]{uri.getLastPathSegment()};
                return ((NoticiasApplication)getContext()).getDb().delete("Autor", selection, selectionArgs);
            default:
                throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    //content://com.example.profesormanana.com.example.profesormanana.contentproviders/Noticia

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        switch(uriMatcher.match(uri)){
            case CODE_NOTICIAS:
                long id = ((NoticiasApplication)getContext()).getDb().insert(Noticia.TABLA_NOTICIA, Noticia.NOTICIA_CAMPO_ID, values);
                return Uri.withAppendedPath(uri, String.valueOf(id));
            default:
                throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    //http://localhost:8080/AplicacionNoticiasRest/rest/Noticia/1

    //content://com.example.profesormanana.com.example.profesormanana.contentproviders/Noticia
    //content://com.example.profesormanana.com.example.profesormanana.contentproviders/Noticia/1

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        switch(uriMatcher.match(uri)){
            case CODE_NOTICIA:
                selection = Noticia.NOTICIA_CAMPO_ID + " = ?";
                selectionArgs = new String[]{uri.getLastPathSegment()};
            case CODE_NOTICIAS:
                return ((NoticiasApplication)getContext()).getDb().query(Noticia.TABLA_NOTICIA, projection, selection, selectionArgs, null, null, sortOrder);
            default:
                throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    //content://com.example.profesormanana.com.example.profesormanana.contentproviders/Noticia/1

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        switch(uriMatcher.match(uri)){
            case CODE_NOTICIA:
                selection = Noticia.NOTICIA_CAMPO_ID + " = ?";
                selectionArgs = new String[]{uri.getLastPathSegment()};
                return ((NoticiasApplication)getContext()).getDb().update(Noticia.TABLA_NOTICIA, values, selection, selectionArgs);
            default:
                throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    @Override
    public String getType(Uri uri) {
        switch(uriMatcher.match(uri)) {
            case CODE_NOTICIA:
                return "android.cursor.item/vnd." + NoticiasContentProviderUtil.AUTHORITY  + "." + Noticia.TABLA_NOTICIA.toLowerCase();
            case CODE_NOTICIAS:
                return "android.cursor.dir/vnd." + NoticiasContentProviderUtil.AUTHORITY  + "." + Noticia.TABLA_NOTICIA.toLowerCase();
            case CODE_AUTOR:
                return "android.cursor.item/vnd." + NoticiasContentProviderUtil.AUTHORITY  + "." + "autor";
            case CODE_AUTORES:
                return "android.cursor.dir/vnd." + NoticiasContentProviderUtil.AUTHORITY  + "." + "autor";
            default:
                return null;
        }
    }
}
