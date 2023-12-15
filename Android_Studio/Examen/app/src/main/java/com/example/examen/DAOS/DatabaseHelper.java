package com.example.examen.DAOS;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DE_DATOS = "BdPalabras";
    private static final int VERSION_BASE_DE_DATOS = 1;
    private static DatabaseHelper databaseHelper = null;

    private DatabaseHelper(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaPalabra = "CREATE TABLE IF NOT EXISTS palabra (" +
                "id_palabra INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "nombre TEXT NOT NULL, " +
                "aparecido INTEGER NOT NULL, " +
                "acertada INTEGER NOT NULL);";

        //FOREIGN KEY (id_padre) REFERENCES tabla_padre(id)
        db.execSQL(queryCrearTablaPalabra);

        insertarPalabraDefault(db, "belleza", 0, 0);
        insertarPalabraDefault(db, "basket", 0, 0);
        insertarPalabraDefault(db, "alarma", 0, 0);
        insertarPalabraDefault(db, "sufrir", 0, 0);
        insertarPalabraDefault(db, "café", 0, 0);
        insertarPalabraDefault(db, "serenidad", 0, 0);
        insertarPalabraDefault(db, "hojaldre", 0, 0);
        insertarPalabraDefault(db, "normal", 0, 0);
        insertarPalabraDefault(db, "Código", 0, 0);
        insertarPalabraDefault(db, "hola", 0, 0);
        insertarPalabraDefault(db, "adios", 0, 0);
        insertarPalabraDefault(db, "que", 0, 0);
        insertarPalabraDefault(db, "si", 0, 0);
        insertarPalabraDefault(db, "no", 0, 0);
        insertarPalabraDefault(db, "ventana", 0, 0);
        insertarPalabraDefault(db, "puerta", 0, 0);
        insertarPalabraDefault(db, "casco", 0, 0);
        insertarPalabraDefault(db, "moto", 0, 0);
        insertarPalabraDefault(db, "coche", 0, 0);
        insertarPalabraDefault(db, "raton", 0, 0);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    private void insertarPalabraDefault(SQLiteDatabase db, String nombre, int aparecido, int acertada) {
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("aparecido", aparecido);
        valores.put("acertada", acertada);
        db.insert("palabra", null, valores);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(context.getApplicationContext());
        }
        return databaseHelper;
    }
}


