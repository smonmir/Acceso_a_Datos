package com.example.examen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.examen.POJO.Palabra;
import com.example.examen.Servicio.Servicio;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class JugarSiguiente extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Palabra> listaPalabras;
    private ArrayList<Palabra> listaPalabrasAparecidas;
    private TextView txtLista;
    private Servicio servicio;
    private EditText txtNombre;
    private Button btnValidar;
    private Handler handler;
    private int aciertos = 0;
    private int puntuacionMaxima = 0;
    private SimularCargaTask cargaTask;
    private Button btnVolverJugarSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar_siguiente);

        listView = findViewById(R.id.listViewAcertadas);

        servicio = Servicio.getInstance(this);

        listaPalabras = servicio.obtenerPalabrasMostradas();

        txtNombre = findViewById(R.id.txtNombre);

        btnValidar = findViewById(R.id.btnValidar);

        btnVolverJugarSiguiente = findViewById(R.id.btnVolverJugarSiguiente);

        listaPalabrasAparecidas = new ArrayList<Palabra>();

        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarPalabra(txtNombre.getText().toString());
                txtNombre.setText("");
            }
        });

        cargaTask = new SimularCargaTask();

        cargaTask.execute();

        btnVolverJugarSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargaTask.cancel(true);
            }
        });
/*
        btnVolverJugarSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JugarSiguiente.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finishAffinity();
            }
        });
    */

        /*
        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 15000);

        */
    }

    private void mostrarPalabras(Palabra palabra){

        listaPalabrasAparecidas.add(palabra);

        ArrayAdapter<Palabra> adapter = new ArrayAdapter<Palabra>(this, android.R.layout.simple_list_item_1, listaPalabrasAparecidas) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                txtLista = view.findViewById(android.R.id.text1);

                txtLista.setText(listaPalabrasAparecidas.get(position).getNombre());

                return view;
            }
        };
        listView.setAdapter(adapter);
    }


    private void comprobarPalabra(String nombre){
        for(int i=0; i<listaPalabras.size(); i++){
            if(listaPalabras.get(i).getNombre().equals(nombre) && listaPalabras.get(i).isAparecido()){
                mostrarPalabras(listaPalabras.get(i));
                aciertos++;
            }
        }
    }

    private void alertaFin(){
        int puntuacion = obtenerPuntuacionMaxima();

        if(aciertos > puntuacion){
            puntuacionMaxima = aciertos;
        }

        SharedPreferences sharedPref = getSharedPreferences("puntuacionMaxima", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("numPuntuacion", puntuacionMaxima);
        editor.apply();

        AlertDialog.Builder builder = new AlertDialog.Builder(JugarSiguiente.this);

        builder.setTitle("Puntuacion");
        builder.setMessage("Numero de palabras acertadas: "+aciertos);
        builder.setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(JugarSiguiente.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finishAffinity();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private int obtenerPuntuacionMaxima(){
        SharedPreferences sharedPref = getSharedPreferences("puntuacionMaxima", Context.MODE_PRIVATE);
        puntuacionMaxima = sharedPref.getInt("numPuntuacion", 0);
        return puntuacionMaxima;
    }


    private class SimularCargaTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
        }
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 0; i < 15; i++) {
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
            alertaFin();
        }
        @Override
        protected void onCancelled() {
            alertaFin();
        }
    }

}