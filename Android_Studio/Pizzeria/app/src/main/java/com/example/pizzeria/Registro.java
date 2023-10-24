package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pizzeria.Servicio.Servicio;

public class Registro extends AppCompatActivity {

    private Button btnAceptar, btnCancelar;
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
}