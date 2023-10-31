package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pizzeria.POJO.Pizza;

public class ConfirmacionPedido extends AppCompatActivity {

    private String nombrePizza;
    private Button btnAceptar, btnCancelar;
    private TextView txtPizza, txtTamano, txtPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_pedido);

        btnAceptar = findViewById(R.id.btnAceptarConfirmacion);
        btnCancelar = findViewById(R.id.btnCancelarConfirmacion);

        txtPizza = findViewById(R.id.txtViewPizzaSelecionada);
        txtTamano = findViewById(R.id.txtViewTamano);
        txtPrecio = findViewById(R.id.txtViewPrecio);

        txtPizza.setText(nombrePizza.toUpperCase());

        Intent intent = getIntent();
        if (intent != null) {
            nombrePizza = intent.getParcelableExtra("pizzaSeleccionada");

            // Ahora, "variableRecibida" contiene el objeto que pasaste desde PizzaPredeterminada
            // Puedes usarlo como necesites.
        }

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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