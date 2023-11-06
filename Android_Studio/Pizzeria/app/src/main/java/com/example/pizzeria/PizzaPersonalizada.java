package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pizzeria.POJO.Pizza;
import com.example.pizzeria.POJO.tipoTamano;
import com.example.pizzeria.Servicio.Servicio;

import java.util.Iterator;
import java.util.Map;

public class PizzaPersonalizada extends AppCompatActivity {

    private Servicio servicio;
    private Map<Pizza, Pizza> pizzas;
    private String[] tamanos;
    private TextView txtNombrePizza;
    private TextView txtIngredientesPizza;
    private Spinner spinner;
    private LinearLayout linearLayout;
    private LinearLayout.LayoutParams layoutParams;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_personalizada);

        servicio = Servicio.getInstance();
        pizzas = servicio.getPizzas();

        spinner = findViewById(R.id.spinner);
        linearLayout = findViewById(R.id.linearLayout);
        listView = findViewById(R.id.listView);

        mostrarPizzas(pizzas);

        tamanos = new String[]{tipoTamano.PEQUENO.getTamano(),tipoTamano.MEDIANO.getTamano(),tipoTamano.GRANDE.getTamano()};

        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tamanos);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

    }

    public void mostrarPizzas(Map<Pizza, Pizza> pizzas){
        Iterator<Map.Entry<Pizza, Pizza>> iterator = pizzas.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Pizza, Pizza> entry = iterator.next();
            Pizza key = entry.getKey();
            Pizza value = entry.getValue();

            layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(300, 100, 0, 0);

            txtNombrePizza = new TextView(this);
            txtNombrePizza.setLayoutParams(layoutParams);
            txtNombrePizza.setText("Pizza: "+value.getNombre());
            txtNombrePizza.setTextSize(20);
            linearLayout.addView(txtNombrePizza);

            txtIngredientesPizza = new TextView(this);
            txtIngredientesPizza.setLayoutParams(layoutParams);
            txtIngredientesPizza.setText("Ingredientes: "+value.getIngredientes().toString());
            txtIngredientesPizza.setTextSize(20);
            linearLayout.addView(txtIngredientesPizza);
        }
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