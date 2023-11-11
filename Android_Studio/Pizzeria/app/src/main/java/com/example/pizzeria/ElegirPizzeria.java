package com.example.pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.TextView;

public class ElegirPizzeria extends AppCompatActivity {

    private Button btnPizzaPersonalizada, btnPredeterminada, btnRepUltPedido, btnVolver;
    private TextView textViewElegirPizzeria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_pizzeria);

        btnPizzaPersonalizada = findViewById(R.id.btnPersonalizada);
        btnPredeterminada = findViewById(R.id.btnPredeterminadas);
        btnRepUltPedido = findViewById(R.id.btnRepUltPedido);
        btnVolver = findViewById(R.id.btnVolver2);

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

        btnRepUltPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ElegirPizzeria.this, ConfirmacionPedido.class);
                SharedPreferences sharedPreferences = getSharedPreferences("UltPizza", Context.MODE_PRIVATE);

                // Comprobar si SharedPreferences contiene datos del utlimo pedido
                if (!sharedPreferences.getAll().isEmpty()) {
                    String nombrePizza = sharedPreferences.getString("pizza", "");
                    String tamano = sharedPreferences.getString("tamano", "");
                    String precio = sharedPreferences.getString("precio", "");

                    i.putExtra("nombrePizza", nombrePizza);
                    i.putExtra("tamano", tamano);
                    i.putExtra("precio", precio);
                    i.putExtra("fuente", "RepUlt");

                    startActivity(i);
                }
                else{
                    alertaIncorrecto();
                }

            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
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
        textViewElegirPizzeria = findViewById(R.id.textViewElegirPizzeria);

        int textColor = getResources().getColor(colorResId);

        textViewElegirPizzeria.setTextColor(textColor);
    }


    private void alertaIncorrecto(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ElegirPizzeria.this);

        String message = "No se ha realizado ningun pedido.";

        //Cambiar color de texto y alinearlo al centro
        SpannableString spannableMessage = new SpannableString(message);
        spannableMessage.setSpan(new ForegroundColorSpan(Color.WHITE), 0, message.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableMessage.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, message.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        builder.setMessage(spannableMessage);

        AlertDialog dialog = builder.create();

        //Cambiar posicion
        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        layoutParams.y = 800;

        dialog.getWindow().setAttributes(layoutParams);
        //Cambiar color de fondo
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog);

        dialog.show();

        //Tiempo de duracion del AlertDialog
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 2000);
    }
}