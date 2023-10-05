package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSaludar = (Button) findViewById(R.id.btnSaludar);

        btnSaludar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView textMensaje = findViewById(R.id.txtSaludo);
        textMensaje.setText("Funciona");
    }


    /*
    public void cambiaMensaje(View view){
        TextView textMensaje = findViewById(R.id.txtSaludo);
        textMensaje.setText("Funciona");
    }
    */


}