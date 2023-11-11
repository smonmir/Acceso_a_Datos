package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CargarPedido extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView txtRealizandoPedido;
    private Handler handler = new Handler();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_pedido);

        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Ocultar la barra de progreso después de la simulación de carga
                progressBar.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(CargarPedido.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finishAffinity();
            }
        }, 5000);
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
        txtRealizandoPedido = findViewById(R.id.txtConfirmarPedido);

        int textColor = getResources().getColor(colorResId);

        txtRealizandoPedido.setTextColor(textColor);
        progressBar.getIndeterminateDrawable().setColorFilter(textColor, PorterDuff.Mode.SRC_IN);
    }
}