package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

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

public class PizzaPredeterminada extends AppCompatActivity {

    private Servicio servicio;
    private Map<Pizza, Pizza> pizzas;
    private String[] tamanos;
    private TextView txtNombrePizza, txtIngredientesPizza;
    private Spinner spinner;
    private LinearLayout linearLayout, item;
    private LinearLayout.LayoutParams layoutParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_predeterminada);

        servicio = Servicio.getInstance();
        pizzas = servicio.getPizzas();

        spinner = findViewById(R.id.spinnerPredeterminada);
        linearLayout = findViewById(R.id.linearLayoutPredeterminada);

        mostrarPizzas(pizzas);

        spinnerTamanos();

    }


    public void mostrarPizzas(Map<Pizza, Pizza> pizzas){
        Iterator<Map.Entry<Pizza, Pizza>> iterator = pizzas.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Pizza, Pizza> entry = iterator.next();
            Pizza key = entry.getKey();
            Pizza value = entry.getValue();

            item = new LinearLayout(this);
            item.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 0, 0, 0);

            txtNombrePizza = new TextView(this);
            txtNombrePizza.setLayoutParams(layoutParams);
            txtNombrePizza.setText("Pizza: "+value.getNombre());
            txtNombrePizza.setTextSize(20);

            item.addView(txtNombrePizza);

            linearLayout.addView(item);

            /*
            txtIngredientesPizza = new TextView(this);
            txtIngredientesPizza.setLayoutParams(layoutParams);
            txtIngredientesPizza.setText("Ingredientes: "+value.getIngredientes().toString());
            txtIngredientesPizza.setTextSize(20);
            linearLayout.addView(txtIngredientesPizza);
            */

        }
    }

    private void spinnerTamanos(){
        tamanos = new String[]{tipoTamano.PEQUENO.getTamano(),tipoTamano.MEDIANO.getTamano(),tipoTamano.GRANDE.getTamano()};
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tamanos);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }
}