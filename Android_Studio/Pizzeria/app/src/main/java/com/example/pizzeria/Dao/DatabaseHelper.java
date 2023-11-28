package com.example.pizzeria.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DE_DATOS = "BDPizzeria";
    private static final int VERSION_BASE_DE_DATOS = 1;

    private static DatabaseHelper databaseHelper = null;

    private DatabaseHelper(Context context) {
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

        // Inserción de datos por defecto en la tabla pizzas
        insertarPizzaDefault(db, "Pizza Margarita", "Mediana", "10.99", "Tomate, Queso, Albahaca");
        insertarPizzaDefault(db, "Pizza Pepperoni", "Grande", "12.99", "Tomate, Queso, Pepperoni");

        String queryCrearTablaUsuario = "CREATE TABLE IF NOT EXISTS usuarios(" +
                "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "nombre TEXT NOT NULL," +
                "contrasena TEXT NOT NULL);";
        db.execSQL(queryCrearTablaUsuario);

        // Inserción de datos por defecto en la tabla usuarios
        insertarUsuarioDefault(db, "admin", "admin");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(context.getApplicationContext());
        }
        return databaseHelper;
    }

    private void insertarPizzaDefault(SQLiteDatabase db, String nombre, String tamano, String precio, String ingredientes) {
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("tamano", tamano);
        valores.put("precio", precio);
        valores.put("ingrediente", ingredientes);
        db.insert("pizzas", null, valores);
    }

    private void insertarUsuarioDefault(SQLiteDatabase db, String nombre, String contrasena) {
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("contrasena", contrasena);
        db.insert("usuarios", null, valores);
    }


}
