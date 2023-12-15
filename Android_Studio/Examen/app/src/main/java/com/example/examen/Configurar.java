package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Configurar extends AppCompatActivity {
    private String[] dificultades;
    private Spinner spinnerDificultad;
    private Button btnVolver, btnListarPalabras;
    private String dificultadSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);

        btnVolver = findViewById(R.id.btnVolverConfigurar);

        btnListarPalabras = findViewById(R.id.btnListarPalabras);

        spinnerDificultad = findViewById(R.id.spinner);

        spinnerDificultad();

        btnListarPalabras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Configurar.this, ListaPalabras.class);
                startActivity(i);
            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dificultadSelecionada = (String) spinnerDificultad.getSelectedItem();

                SharedPreferences sharedPref = getSharedPreferences("dificultad", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("dificultadSeleccionada", dificultadSelecionada);
                editor.apply();
                finish();
            }
        });


    }

    private void spinnerDificultad(){
        dificultades = new String[]{"facil", "medio", "dificil"};
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dificultades);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDificultad.setAdapter(spinnerAdapter);
    }
}