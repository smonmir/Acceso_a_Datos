package com.example.pizzeria.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

        try (SQLiteDatabase db = databaseHelper.getWritableDatabase()) {
            ContentValues valores = new ContentValues();
            valores.put("nombre", nombre);
            valores.put("tamano", tamano);
            valores.put("precio", precio);
            valores.put("ingredientes", ingrediente);

            long resultado = db.insert("pizzas", null, valores);

            if (resultado != -1) {
                Log.i("Database", "Pizza agregada correctamente a la base de datos.");
            } else {
                // Manejar el error de inserción
                Log.e("Database", "Error al agregar pizza a la base de datos.");
            }
        } catch (Exception e) {
            // Manejar la excepción
            Log.e("Database", "Error al abrir o cerrar la base de datos: " + e.getMessage());
        }
    }



    public void modificarPizza(Context context, String nombrePizza, String nuevoTamano, String nuevoPrecio, String nuevosIngredientes) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

        try (SQLiteDatabase db = databaseHelper.getWritableDatabase()) {
            ContentValues valores = new ContentValues();
            valores.put("tamano", nuevoTamano);
            valores.put("precio", nuevoPrecio);
            valores.put("ingredientes", nuevosIngredientes);

            String whereClause = "nombre = ?";
            String[] whereArgs = {nombrePizza};

            int filasAfectadas = db.update("pizzas", valores, whereClause, whereArgs);

            if (filasAfectadas > 0) {
                Log.i("Database", "Pizza modificada correctamente en la base de datos.");
            } else {
                // Manejar el caso en que no se encuentre la pizza con el nombre proporcionado
                Log.w("Database", "No se encontró una pizza con el nombre proporcionado para modificar.");
            }
        } catch (Exception e) {
            // Manejar la excepción
            Log.e("Database", "Error al abrir o cerrar la base de datos: " + e.getMessage());
        }
    }

    public void eliminarPizza(Context context, String nombrePizza) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

        try (SQLiteDatabase db = databaseHelper.getWritableDatabase()) {
            String whereClause = "nombre" + " = ?";
            String[] whereArgs = {nombrePizza};

            int filasAfectadas = db.delete("pizzas", whereClause, whereArgs);

            if (filasAfectadas > 0) {
                Log.i("Database", "Pizza eliminada correctamente de la base de datos.");
            } else {
                // Manejar el caso en que no se encuentre la pizza con el nombre proporcionado
                Log.w("Database", "No se encontró una pizza con el nombre proporcionado.");
            }
        } catch (Exception e) {
            // Manejar la excepción
            Log.e("Database", "Error al abrir o cerrar la base de datos: " + e.getMessage());
        }
    }

    //ELIMINAR SI TUVIESE MAS DE UN PARAMETRO EN EL WHERE
/*
    public void eliminarPizza(Context context, String nombrePizza, String tamanoPizza) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

        try (SQLiteDatabase db = databaseHelper.getWritableDatabase()) {
            String whereClause = "nombre" + " = ? AND " + "tamano" + " = ?";
            String[] whereArgs = {nombrePizza, tamanoPizza};

            int filasAfectadas = db.delete("pizzas", whereClause, whereArgs);

            if (filasAfectadas > 0) {
                Log.i("Database", "Pizza eliminada correctamente de la base de datos.");
            } else {
                // Manejar el caso en que no se encuentre la pizza con el nombre y tamaño proporcionados
                Log.w("Database", "No se encontró una pizza con el nombre y tamaño proporcionados para eliminar.");
            }
        } catch (Exception e) {
            // Manejar la excepción
            Log.e("Database", "Error al abrir o cerrar la base de datos: " + e.getMessage());
        }
    }
*/

    /*
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
    */




}
