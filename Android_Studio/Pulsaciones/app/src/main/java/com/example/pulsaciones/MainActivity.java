package com.example.pulsaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int cont = 0;
    private Button btnSumar;
    private Button btnRestar;
    private Button btnReset;
    private TextView textMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSumar = findViewById(R.id.btnSuma);
        btnRestar = findViewById(R.id.btnResta);
        btnReset = findViewById(R.id.btnReset);
        textMensaje = findViewById(R.id.txtPulsaciones);

        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        /*
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
        */
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSuma){
            cont++;
        }
        else if(v.getId() == R.id.btnResta){
            cont--;
        }
        else if(v.getId() == R.id.btnReset){
            cont = 0;
        }
        textMensaje.setText(String.valueOf(cont));
    }

}