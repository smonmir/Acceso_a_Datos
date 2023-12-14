package com.example.pizzeria.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.pizzeria.POJO.Pizza;
import com.example.pizzeria.POJO.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DaoUsuario {

    public static Map<Usuario, Usuario> getUsuarios(Context context) {

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

        Map<Usuario, Usuario> mapaUsuarios = new LinkedHashMap<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios", null);

        if (cursor.moveToFirst()) {
            int nombreIndex = cursor.getColumnIndex("nombre");
            int contrasenaIndex = cursor.getColumnIndex("contrasena");

            do {
                if (nombreIndex != -1 && contrasenaIndex != -1) {
                    String nombre = cursor.getString(nombreIndex);
                    String contrasenaString = cursor.getString(contrasenaIndex);
                    Usuario usuario = new Usuario(nombre, contrasenaString);
                    mapaUsuarios.put(usuario, usuario);
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return mapaUsuarios;
    }



    public static void insertarUsuario(Context context, String nombre, String contrasena) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

        try (SQLiteDatabase db = databaseHelper.getWritableDatabase()) {
            ContentValues valores = new ContentValues();
            valores.put("nombre", nombre);
            valores.put("contrasena", contrasena);

            long resultado = db.insert("usuarios", null, valores);

            if (resultado != -1) {
                Log.i("Database", "Usuario agregado correctamente a la base de datos.");
            } else {
                // Manejar el error de inserción
                Log.e("Database", "Error al agregar usuario a la base de datos.");
            }
        } catch (Exception e) {
            // Manejar la excepción
            Log.e("Database", "Error al abrir o cerrar la base de datos: " + e.getMessage());
        }
    }


    public static void modificarUsuario(Context context, String nombre, String nuevaContrasena){
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

        try (SQLiteDatabase db = databaseHelper.getWritableDatabase()) {
            ContentValues valores = new ContentValues();

            valores.put("contrasena", nuevaContrasena);

            int filasAfectadas = db.update("usuarios", valores, "nombre = ?", new String[]{nombre});

            if (filasAfectadas > 0) {
                Log.i("Database", "Usuario modificado correctamente en la base de datos.");
            } else {
                // Manejar el caso en que no se encuentre el usuario con el nombre proporcionado
                Log.w("Database", "No se encontró un usuario con el nombre proporcionado.");
            }
        } catch (Exception e) {
            // Manejar la excepción
            Log.e("Database", "Error al abrir o cerrar la base de datos: " + e.getMessage());
        }

    }


    public static void eliminarUsuario(Context context, String nombre) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

        try (SQLiteDatabase db = databaseHelper.getWritableDatabase()) {
            String whereClause = "nombre = ?";
            String[] whereArgs = {nombre};

            int filasAfectadas = db.delete("usuarios", whereClause, whereArgs);

            if (filasAfectadas > 0) {
                Log.i("Database", "Usuario eliminado correctamente de la base de datos.");
            } else {
                // Manejar el caso en que no se encuentre el usuario con el nombre proporcionado
                Log.w("Database", "No se encontró un usuario con el nombre proporcionado.");
            }
        } catch (Exception e) {
            // Manejar la excepción
            Log.e("Database", "Error al abrir o cerrar la base de datos: " + e.getMessage());
        }
    }


    /*
    public static void insertarUsuario(Context context, String nombre, String contrasena) {

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("contrasena", contrasena);

        db.insert("usuarios", null, valores);
        db.close();
    }

    public static void modificarUsuario(Context context, String nombre, String nuevaContrasena){
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("contrasena", nuevaContrasena);

        db.update("usuarios", valores, "nombre = ?", new String[]{nombre});
        db.close();
    }


    public static void eliminarUsuario(Context context, String nombre) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        String whereClause = "nombre = ?";
        String[] whereArgs = {nombre};

        db.delete("usuarios", whereClause, whereArgs);
        db.close();
    }
    */

}


