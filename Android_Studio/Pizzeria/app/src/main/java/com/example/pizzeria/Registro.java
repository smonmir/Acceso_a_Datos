package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pizzeria.Servicio.Servicio;

public class Registro extends AppCompatActivity {

    private Button btnAceptar, btnCancelar;
    private TextView txtViewRegistro, txtViewUsuario2, txtViewContrasena2;
    private EditText usuario, contrasena;
    private Servicio servicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        servicio = Servicio.getInstance();

        btnAceptar = findViewById(R.id.btnAceptarRegistro);
        btnCancelar = findViewById(R.id.btnCancelarRegistro);
        usuario = findViewById(R.id.edTxtUsuario);
        contrasena = findViewById(R.id.edTxtContrasena);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                servicio.anadirUsuario(usuario.getText().toString(), contrasena.getText().toString());
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
        txtViewRegistro = findViewById(R.id.txtViewRegistro);
        txtViewUsuario2 = findViewById(R.id.txtViewUsuario2);
        txtViewContrasena2 = findViewById(R.id.txtViewContrasena2);

        int textColor = getResources().getColor(colorResId);
        int textColorHint =  getResources().getColor(R.color.colorHint);

        txtViewRegistro.setTextColor(textColor);
        txtViewUsuario2.setTextColor(textColor);
        txtViewContrasena2.setTextColor(textColor);
        usuario.setTextColor(textColor);
        usuario.setHintTextColor(textColorHint);
        contrasena.setTextColor(textColor);
        contrasena.setHintTextColor(textColorHint);

    }

}