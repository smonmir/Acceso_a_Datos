package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Puntuaciones extends AppCompatActivity {

    private TextView txtPuntuacion;
    private Button btnVolver;

    private int puntuacionTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);

        txtPuntuacion = findViewById(R.id.txtPuntuacion);
        btnVolver = findViewById(R.id.btnVolver);

        SharedPreferences sharedPref = getSharedPreferences("puntuacionMaxima", Context.MODE_PRIVATE);
        puntuacionTotal = sharedPref.getInt("numPuntuacion", 0);

        txtPuntuacion.setText(puntuacionTotal+"");

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}