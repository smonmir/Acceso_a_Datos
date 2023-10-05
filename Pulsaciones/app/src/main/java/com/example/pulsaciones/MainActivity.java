package com.example.pulsaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int cont = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSumar = (Button) findViewById(R.id.btnSuma);
        Button btnRestar = (Button) findViewById(R.id.btnResta);
        Button btnReset = (Button) findViewById(R.id.btnReset);
        TextView textMensaje = findViewById(R.id.textoPulsacion);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                textMensaje.setText(String.valueOf(cont));
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont--;
                textMensaje.setText(String.valueOf(cont));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont = 0;
                textMensaje.setText(String.valueOf(cont));
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
}