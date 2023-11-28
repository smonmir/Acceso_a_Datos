package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pizzeria.POJO.Pizza;
import com.example.pizzeria.POJO.TipoTamano;
import com.example.pizzeria.Servicio.Servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConfirmacionPedido extends AppCompatActivity {

    private Servicio servicio;
    private Map<Pizza, Pizza> pizzas;
    private String nombrePizza, tamano, precio, ingredientes;
    private int cantIngredientes;
    private ArrayList<String> listaIngredientes;

    private Button btnAceptar, btnCancelar;

    private TextView txtPizza, txtTamano, txtPrecio, txtConfirmarPedido, txtPizzaSeleccionada, textViewTamano, txtViewPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_pedido);

        servicio = Servicio.getInstance(this);
        pizzas = servicio.getPizzas();

        btnAceptar = findViewById(R.id.btnAceptarConfirmacion);
        btnCancelar = findViewById(R.id.btnCancelarConfirmacion);

        txtPizza = findViewById(R.id.txtViewPizzaSelecionada);
        txtTamano = findViewById(R.id.txtTamano);
        txtPrecio = findViewById(R.id.txtPrecio);


        Intent intent = getIntent();
        String fuente = intent.getStringExtra("fuente");

        //Comprobar desde que Activity se ha iniciado este activity
        if ("Predeterminada".equals(fuente)) {
            nombrePizza = intent.getStringExtra("pizzaSeleccionada");
            txtPizza.setText(nombrePizza);

            tamano = intent.getStringExtra("tamañoSeleccionado");
            txtTamano.setText(tamano);

            ingredientes = intent.getStringExtra("cantIngredientes");
            cantIngredientes = Integer.parseInt(ingredientes);

            precio = buscarPrecioPizza()+"€";
            txtPrecio.setText(precio);
        }
        else if ("RepUlt".equals(fuente)) {
            nombrePizza = intent.getStringExtra("nombrePizza");
            txtPizza.setText(nombrePizza);

            tamano = intent.getStringExtra("tamano");
            txtTamano.setText(tamano);

            precio = intent.getStringExtra("precio");;
            txtPrecio.setText(precio);
        }
        else if("PersoPizza".equals(fuente)){
            nombrePizza = intent.getStringExtra("nombrePizza");
            txtPizza.setText(nombrePizza);

            tamano = intent.getStringExtra("tamano");
            txtTamano.setText(tamano);

            //listaIngredientes
            ingredientes = intent.getStringExtra("cantIngredientes");
            cantIngredientes = Integer.parseInt(ingredientes);

            precio = buscarPrecioPizza()+"€";
            txtPrecio.setText(precio);
        }

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("UltPizza", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("pizza", nombrePizza);
                editor.putString("tamano", tamano);
                editor.putString("precio", precio);

                //Se eliminan los datos del SharedPreference, para comprobar el alertDialog del activity ElegirPizza
                /*
                editor.remove("pizza");
                editor.remove("tamano");
                editor.remove("precio");
                */

                editor.apply();

                Intent i = new Intent(ConfirmacionPedido.this, CargarPedido.class);
                startActivity(i);
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

                if(tamano.equalsIgnoreCase("Pequeño")){
                    value.setTamano(TipoTamano.PEQUENO);
                }
                else{
                    for (TipoTamano tipoTamano : TipoTamano.values()) {
                        if (tipoTamano.name().equalsIgnoreCase(tamano)) {
                            value.setTamano(tipoTamano);
                        }
                    }
                }

                //TODO
                //cambiar el arrayList ingredientes por mapa de <ingredente,cantidad>
                return value.getPrecio() + cantIngredientes*2;
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
            changeTextViewColor(R.color.colorFondoOff);
        } else {
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorFondoOff));
            changeTextViewColor(R.color.colorFondoOn);
        }
    }

    private void changeTextViewColor(int colorResId) {
        txtConfirmarPedido = findViewById(R.id.txtConfirmarPedido);
        txtPizzaSeleccionada = findViewById(R.id.txtPizzaSeleccionada);
        textViewTamano = findViewById(R.id.textViewTamano);
        txtViewPrecio = findViewById(R.id.txtViewPrecio);

        int textColor = getResources().getColor(colorResId);

        txtConfirmarPedido.setTextColor(textColor);
        txtPizzaSeleccionada.setTextColor(textColor);
        textViewTamano.setTextColor(textColor);
        txtViewPrecio.setTextColor(textColor);
        txtPizza.setTextColor(textColor);
        txtTamano.setTextColor(textColor);
        txtPrecio.setTextColor(textColor);
    }

}