package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CargarPedido extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView txtRealizandoPedido;
    private Button btnDetener;
    private Handler handler;
    private SimularCargaTask cargaTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_pedido);

        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        btnDetener = findViewById(R.id.btnDetener);

        handler = new Handler();

        cargaTask = new SimularCargaTask();

        cargaTask.execute();

        btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargaTask.cancel(true);
            }
        });
    }

    private class SimularCargaTask extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
        }
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 0; i < 10; i++) {
                    if (isCancelled()) {
                        break;
                    }
                    else{
                        Thread.sleep(500);
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            progressBar.setVisibility(View.INVISIBLE);
            btnDetener.setVisibility(View.INVISIBLE);

            Intent intent = new Intent(CargarPedido.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

            finishAffinity();
        }
        @Override
        protected void onCancelled() {
            finish();
        }
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
        txtRealizandoPedido = findViewById(R.id.txtRealizandoPedido);

        int textColor = getResources().getColor(colorResId);

        txtRealizandoPedido.setTextColor(textColor);
        progressBar.getIndeterminateDrawable().setColorFilter(textColor, PorterDuff.Mode.SRC_IN);
    }
}