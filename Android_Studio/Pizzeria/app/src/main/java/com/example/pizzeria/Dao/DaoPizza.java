package com.example.pizzeria.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pizzeria.POJO.Pizza;
import com.example.pizzeria.POJO.TipoIngrediente;
import com.example.pizzeria.POJO.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DaoPizza {

    public static Map<Pizza, Pizza> pizzas(Context context) {

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

        Map<Pizza, Pizza> mapaPizzas = new LinkedHashMap<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM pizzas", null);

        if (cursor.moveToFirst()) {
            int nombreIndex = cursor.getColumnIndex("nombre");
            int ingredientesIndex = cursor.getColumnIndex("ingredientes");

            do {
                if (nombreIndex != -1 && ingredientesIndex != -1) {
                    String nombre = cursor.getString(nombreIndex);
                    String ingredientesString = cursor.getString(ingredientesIndex);
                    List<String> ingredientes = Arrays.asList(ingredientesString.split(","));
                    Pizza pizza = new Pizza(nombre, new ArrayList<>(ingredientes));
                    mapaPizzas.put(pizza, pizza);
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return mapaPizzas;
    }

    public void insertarPizza(Context context, String nombre, String tamano, String precio, String ingrediente) {

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("tamano", tamano);
        valores.put("precio", precio);
        valores.put("ingrediente", ingrediente);
        db.insert("pizzas", null, valores);
        db.close();
    }

}
