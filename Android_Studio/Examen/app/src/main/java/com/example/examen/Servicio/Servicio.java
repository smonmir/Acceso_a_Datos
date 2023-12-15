package com.example.examen.Servicio;

import android.content.Context;

import com.example.examen.DAOS.DAOPalabra;
import com.example.examen.POJO.Palabra;

import java.util.ArrayList;
import java.util.List;

public class Servicio {

    private ArrayList<Palabra> palabrasMostrada;
    private static Servicio servicio = null;
    private Context context;

    public Servicio(Context context) {
        this.context = context;
    }

    public void establecerPalabrasMostradas(ArrayList<Palabra> lista){
        this.palabrasMostrada = lista;
    }
    public ArrayList<Palabra> obtenerPalabrasMostradas(){
        return palabrasMostrada;
    }

    public ArrayList<Palabra> obtenerPalabras(Context context){
        ArrayList<Palabra> listaPalabras = DAOPalabra.getPalabras(context);
        return listaPalabras;
    }

    public void modificarPalabra(Context context, Palabra palabra){
        DAOPalabra.modificarPalabra(context, palabra);
    }



















    public void setContext(Context context){
        this.context = context;
    }

    public static Servicio getInstance(Context context){
        if(servicio == null){
            return servicio = new Servicio(context);
        }
        else{
            servicio.setContext(context);
            return servicio;
        }
    }


}
