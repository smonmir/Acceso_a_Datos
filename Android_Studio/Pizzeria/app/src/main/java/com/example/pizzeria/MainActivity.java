package com.example.pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnElegirPizza, btnConfigurar, btnSalir, btnWeb;
    private TextView txtTituloPizzeria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnElegirPizza = findViewById(R.id.btnElegirPizza);
        btnConfigurar = findViewById(R.id.btnConfigurar);
        btnWeb = findViewById(R.id.btnWeb);
        btnSalir = findViewById(R.id.btnSalir);

        btnElegirPizza.setOnClickListener(this);
        btnConfigurar.setOnClickListener(this);
        btnWeb.setOnClickListener(this);
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
        }//"https://pizzerialaroma.com"
        else if(view.getId() == R.id.btnWeb){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.dominospizza.es/"));
            startActivity(intent);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
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


    //Cambio del color de fondo si se selecciono en configuracion
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

    //Cambio del color de texto si se selecciono en configuracion
    private void changeTextViewColor(int colorResId) {
        txtTituloPizzeria = findViewById(R.id.txtTituloPizzeria);

        int textColor = getResources().getColor(colorResId);

        txtTituloPizzeria.setTextColor(textColor);
    }


}