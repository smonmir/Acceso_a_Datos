package com.example.pizzeria.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pizzeria.R;

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
                "ingredientes TEXT);";
        db.execSQL(queryCrearTablaPizza);

        insertarPizzaDefault(db, "Margarita", "Mediana", "10.99", "Tomate, Queso, Albahaca");
        insertarPizzaDefault(db, "Pepperoni", "Grande", "12.99", "Tomate, Queso, Pepperoni");
        insertarPizzaDefault(db, "Barbacoa", "Pequeña", "4.99", "Salsa barbacoa, Mozzarella, Carne de vacuno, Cebolla, Maiz");
        insertarPizzaDefault(db, "Carbonara", "Pequeña", "4.99", "Carne fresca, Mozzarella, Bacon, Champiñon, Cebolla");
        insertarPizzaDefault(db, "Cuatro quesos", "Pequeña", "4.99", "Tomate, Mozzarella, Cheddar, Emmental, Gorgonzola");

        String queryCrearTablaUsuario = "CREATE TABLE IF NOT EXISTS usuarios(" +
                "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "nombre TEXT NOT NULL," +
                "contrasena TEXT NOT NULL);";
        db.execSQL(queryCrearTablaUsuario);

        insertarUsuarioDefault(db, "admin", "admin");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }


    private void insertarPizzaDefault(SQLiteDatabase db, String nombre, String tamano, String precio, String ingredientes) {
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("tamano", tamano);
        valores.put("precio", precio);
        valores.put("ingredientes", ingredientes);
        db.insert("pizzas", null, valores);
    }

    private void insertarUsuarioDefault(SQLiteDatabase db, String nombre, String contrasena) {
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("contrasena", contrasena);
        db.insert("usuarios", null, valores);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(context.getApplicationContext());
        }
        return databaseHelper;
    }




}
