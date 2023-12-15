package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.examen.POJO.Palabra;
import com.example.examen.Servicio.Servicio;

import java.util.ArrayList;
import java.util.List;

public class Jugar extends AppCompatActivity {

    private ListView listView;
    private String dificultadSeleccionada = "medio";
    private ArrayList<Palabra> listaPalabras;
    private TextView txtLista;
    private Servicio servicio;
    private Handler handler;
    private Button btnVolver;
    private SimularCargaTask cargaTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        listView = findViewById(R.id.listViewPalabras);

        servicio = Servicio.getInstance(this);

        btnVolver = findViewById(R.id.btnVolverJugar);

        listaPalabras = servicio.obtenerPalabras(this);

        mostrarNumeroPalabras(listaPalabras);

        modificacionAparicionPalabras(listaPalabras);



        cargaTask = new SimularCargaTask();

        cargaTask.execute();

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargaTask.cancel(true);
            }
        });

        /*
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        */

        /*
                handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Jugar.this, JugarSiguiente.class);
                startActivity(i);
            }
        }, 5000);
         */

    }


    private void mostrarPalabras(ArrayList<Palabra> listaPalabras){

        ArrayList<Palabra> lista = listaPalabras;
        ArrayAdapter<Palabra> adapter = new ArrayAdapter<Palabra>(this, android.R.layout.simple_list_item_1, lista) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                txtLista = view.findViewById(android.R.id.text1);
                txtLista.setText(lista.get(position).getNombre());

                return view;
            }
        };
        listView.setAdapter(adapter);

        servicio.establecerPalabrasMostradas(lista);
    }

    private void modificacionAparicionPalabras(ArrayList<Palabra> listaPalabras){
        for(int i=0; i<listaPalabras.size(); i++){
            listaPalabras.get(i).setAparecido(true);
            servicio.modificarPalabra(this, listaPalabras.get(i));
        }
    }


    private void mostrarNumeroPalabras(ArrayList<Palabra> listaPalabras){


        int maximasPalabras = dificultad();

        ArrayList<Palabra> lista = new ArrayList<Palabra>();

        for(int i=0; i<maximasPalabras; i++){
            lista.add(listaPalabras.get(i));
        }

        mostrarPalabras(lista);
    }


    private int dificultad(){
        SharedPreferences sharedPref = getSharedPreferences("dificultad", Context.MODE_PRIVATE);
        dificultadSeleccionada = sharedPref.getString("dificultadSeleccionada", "medio");

        int numPalabras = 15;

        switch (dificultadSeleccionada){
            case "facil": numPalabras = 10;
                break;
            case "medio": numPalabras = 15;
                break;
            case "dificil": numPalabras = 20;
                break;
            default: break;
        }
        return numPalabras;
    }


    private ArrayList<Palabra> palabrasNoAparecidas(){

        return null;
    }

    private ArrayList<Palabra> palabrasAparecidasNoAcertadas(){

        return null;
    }


    private ArrayList<Palabra> palabrasAparecidasAcertadas(){

        return null;
    }


    private class SimularCargaTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
        }
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 0; i < 10; i++) {
                    if (isCancelled()) {
                        break;
                    }
                    else{
                        Thread.sleep(500);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            Intent i = new Intent(Jugar.this, JugarSiguiente.class);
            startActivity(i);
        }
        @Override
        protected void onCancelled() {
            finish();
        }
    }

}