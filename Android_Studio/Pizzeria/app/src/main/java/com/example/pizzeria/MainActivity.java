package com.example.pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnElegirPizza, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnElegirPizza = findViewById(R.id.btnElegirPizza);
        btnSalir = findViewById(R.id.btnSalir);

        btnElegirPizza.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnElegirPizza){
            Intent i = new Intent(this, ElegirPizzeria.class);
            startActivity(i);
        }
        else if(view.getId() == R.id.btnConfigurar){
            Intent i = new Intent(this, Configuracion.class);
            startActivity(i);
        }
        else if(view.getId() == R.id.btnSalir){
            alertaSalida();
        }
    }


    //Muestra AlertDialog de confirmacion si se pulsa el boton salir
    private void alertaSalida(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Salir");
        builder.setMessage("¿Seguro que deseas salir?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    //Boton de retroceso del movil
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        alertaSalida();
    }
}