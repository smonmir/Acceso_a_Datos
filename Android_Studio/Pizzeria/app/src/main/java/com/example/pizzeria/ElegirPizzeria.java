package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ElegirPizzeria extends AppCompatActivity {

    private Button btnPizzaPersonalizada, btnPredeterminada;
    private TextView textViewElegirPizzeria;
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

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("switchModo", Context.MODE_PRIVATE);
        boolean switchState = sharedPref.getBoolean("switchColor", false);

        if (switchState) {
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorFondoOn));
            changeTextViewColor(R.color.colorFondoOff);
        } else {
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorFondoOff));
            changeTextViewColor(R.color.colorFondoOn);
        }
    }

    private void changeTextViewColor(int colorResId) {
        textViewElegirPizzeria = findViewById(R.id.textViewElegirPizzeria);

        int textColor = getResources().getColor(colorResId);

        textViewElegirPizzeria.setTextColor(textColor);
    }
}