package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pizzeria.POJO.Pizza;
import com.example.pizzeria.Servicio.Servicio;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConfirmacionPedido extends AppCompatActivity {

    private Servicio servicio;
    private Map<Pizza, Pizza> pizzas;
    private String nombrePizza, tamano;
    private Button btnAceptar, btnCancelar;
    private TextView txtPizza, txtTamano, txtPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_pedido);

        servicio = Servicio.getInstance();
        pizzas = servicio.getPizzas();

        btnAceptar = findViewById(R.id.btnAceptarConfirmacion);
        btnCancelar = findViewById(R.id.btnCancelarConfirmacion);

        txtPizza = findViewById(R.id.txtViewPizzaSelecionada);
        txtTamano = findViewById(R.id.txtViewTamano);
        txtPrecio = findViewById(R.id.txtViewPrecio);

        Intent intent = getIntent();
        nombrePizza = intent.getStringExtra("pizzaSeleccionada");
        txtPizza.setText(nombrePizza);

        tamano = intent.getStringExtra("tamañoSeleccionado");
        txtTamano.setText(tamano);

        txtPrecio.setText(buscarPrecioPizza()+"€");
        ;

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

    private double buscarPrecioPizza(){
        Iterator<Map.Entry<Pizza, Pizza>> iterator = pizzas.entrySet().iterator();
        String pizza = nombrePizza.toUpperCase();
        while (iterator.hasNext()) {
            Map.Entry<Pizza, Pizza> entry = iterator.next();
            Pizza value = entry.getValue();

            if(pizza.equals(value.getNombre().toUpperCase())){
                return value.getPrecio();
            }

        }
        return 0;
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("switchModo", Context.MODE_PRIVATE);
        boolean switchState = sharedPref.getBoolean("switchColor", false);

        if (switchState) {
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorFondoOn));
        } else {
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorFondoOff));
        }
    }

}