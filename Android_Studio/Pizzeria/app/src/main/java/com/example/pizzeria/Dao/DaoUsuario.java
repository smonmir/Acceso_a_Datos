package com.example.pizzeria.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("contrasena", contrasena);
        db.insert("usuarios", null, valores);
        db.close();
    }


}


