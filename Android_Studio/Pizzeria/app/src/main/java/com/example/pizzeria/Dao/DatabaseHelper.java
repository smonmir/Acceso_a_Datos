package com.example.pizzeria.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DE_DATOS = "BDPizzeria";
    private static final int VERSION_BASE_DE_DATOS = 1;

    private static DatabaseHelper bdHelper = null;

    public DatabaseHelper(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaPizza = "CREATE TABLE IF NOT EXISTS pizzas (" +
                "id_pizza INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "nombre TEXT NOT NULL, " +
                "tamano TEXT, " +
                "precio TEXT, " +
                "ingrediente TEXT);";
        db.execSQL(queryCrearTablaPizza);

        String queryCrearTablaUsuario = "CREATE TABLE IF NOT EXISTS usuarios(" +
                "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "nombre TEXT NOT NULL," +
                "contrasena TEXT NOT NULL);";

        db.execSQL(queryCrearTablaUsuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static DatabaseHelper getInstance(Context context){
        if(bdHelper == null){
            return bdHelper = new DatabaseHelper(context);
        }
        return bdHelper;
    }


}
