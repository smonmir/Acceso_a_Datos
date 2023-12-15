package com.example.examen.DAOS;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.examen.POJO.Palabra;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DAOPalabra {

    public static ArrayList<Palabra> getPalabras(Context context) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

        ArrayList<Palabra> listaPalabras = new ArrayList<Palabra>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM palabra", null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex("id_palabra");
            int nombreIndex = cursor.getColumnIndex("nombre");
            int aparecidoIndex = cursor.getColumnIndex("aparecido");
            int acertadaIndex = cursor.getColumnIndex("acertada");

            do {
                if (nombreIndex != -1 && idIndex != -1) {
                    int id = cursor.getInt(idIndex);
                    String nombre = cursor.getString(nombreIndex);
                    int aparecidoInt = cursor.getInt(aparecidoIndex);
                    int acertadaInt = cursor.getInt(acertadaIndex);

                    boolean aparecido, acertada;
                    if(aparecidoInt==0){
                        aparecido = false;
                    }
                    else{
                        aparecido = true;
                    }
                    if(acertadaInt==0){
                        acertada = false;
                    }
                    else{
                        acertada = true;
                    }

                    Palabra palabra = new Palabra(nombre, aparecido, acertada);
                    palabra.setIdPalabra(id);
                    listaPalabras.add(palabra);
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return listaPalabras;
    }


    public static void modificarPalabra(Context context, Palabra palabra) {
        String nombre = palabra.getNombre();
        boolean aparecido = palabra.isAparecido();
        boolean acertada = palabra.isAcertada();

        int aparece = 0, acertado = 0;

        if(aparecido == true){
            aparece = 1;
        }
        if(acertada == true){
            acertado = 1;
        }

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);

        try (SQLiteDatabase db = databaseHelper.getWritableDatabase()) {
            ContentValues valores = new ContentValues();
            valores.put("nombre", nombre);
            valores.put("aparecido", aparecido);
            valores.put("acertada", acertada);

            String whereClause = "nombre = ?";
            String[] whereArgs = {nombre};

            int filasAfectadas = db.update("palabra", valores, whereClause, whereArgs);

            if (filasAfectadas > 0) {
                Log.i("Database", "palabra modificada correctamente en la base de datos.");
            } else {
                // Manejar el caso en que no se encuentre la pizza con el nombre proporcionado
                Log.w("Database", "No se encontró una palanra con el nombre proporcionado para modificar.");
            }
        } catch (Exception e) {
            // Manejar la excepción
            Log.e("Database", "Error al abrir o cerrar la base de datos: " + e.getMessage());
        }
    }


}
