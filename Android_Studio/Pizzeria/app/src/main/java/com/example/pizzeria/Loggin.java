package com.example.pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import com.example.pizzeria.Servicio.Servicio;

import java.nio.file.attribute.FileTime;

public class Loggin extends AppCompatActivity {

    private Button btnConfirmar;
    private Button btnRegistrar;

    private EditText txtUsuario;
    private EditText txtContrasena;
    private Servicio servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnRegistrar = findViewById(R.id.btnRegistrar);

        txtUsuario = findViewById(R.id.txtUsuario);

        txtContrasena = findViewById(R.id.txtContrasena);

        servicio = Servicio.getInstance();

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(servicio.comprobarUsuario(txtUsuario.getText().toString(), txtContrasena.getText().toString())){
                    Intent i = new Intent(Loggin.this, MainActivity.class);
                    startActivity(i);
                }
                else{

                    AlertDialog.Builder builder = new AlertDialog.Builder(Loggin.this);
                    builder.setMessage("Usuario o contraseña incorrecto.");

                    AlertDialog dialog = builder.create();


                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GRAY));

                    dialog.show();
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                        }
                    }, 2000);

                }
            }
        });
    }
}