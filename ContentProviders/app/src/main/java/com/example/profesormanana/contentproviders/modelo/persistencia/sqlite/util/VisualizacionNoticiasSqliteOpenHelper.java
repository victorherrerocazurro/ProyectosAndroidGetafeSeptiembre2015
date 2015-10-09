package com.example.profesormanana.contentproviders.modelo.persistencia.sqlite.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.profesormanana.contentproviders.R;

/**
 * Created by profesormanana on 23/09/15.
 */
public class VisualizacionNoticiasSqliteOpenHelper extends SQLiteOpenHelper {

    private Context context;

    public VisualizacionNoticiasSqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        ejecutarScript(db, context.getResources().getStringArray(R.array.scriptCreacion));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        switch (oldVersion){
            case 1:
                ejecutarScript(db, context.getResources().getStringArray(R.array.scriptActualizacion1_3));
                break;
            case 2:
                ejecutarScript(db, context.getResources().getStringArray(R.array.scriptActualizacion2_3));
                break;
        }
    }

    public static void ejecutarScript(SQLiteDatabase db, String[] script) {
        try {
            db.beginTransaction();

            for (String sql : script) {
                db.execSQL(sql);
            }

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }
}
