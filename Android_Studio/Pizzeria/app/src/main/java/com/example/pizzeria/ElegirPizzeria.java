package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ElegirPizzeria extends AppCompatActivity {

    private Button btnPizzaPersonalizada, btnPredeterminada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_pizzeria);

        btnPizzaPersonalizada = findViewById(R.id.btnPersonalizada);
        btnPredeterminada = findViewById(R.id.btnPredeterminadas);

        btnPizzaPersonalizada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ElegirPizzeria.this, PizzaPersonalizada.class);
                startActivity(i);
            }
        });

        btnPredeterminada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ElegirPizzeria.this, PizzaPredeterminada.class);
                startActivity(i);
            }
        });
    }
}