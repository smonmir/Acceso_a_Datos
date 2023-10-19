package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pizzeria.POJO.Pizza;
import com.example.pizzeria.POJO.tipoTamano;
import com.example.pizzeria.Servicio.Servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PizzaPersonalizada extends AppCompatActivity {

    private Servicio servicio;
    private Map<Pizza, Pizza> pizzas;
    private Pizza pizzaSeleccionada;
    private String[] tamanos;
    private ListView listView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_personalizada);

        servicio = Servicio.getInstance();
        pizzas = servicio.getPizzas();

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);

        // Convierte el Map en una lista de elementos
        List<Pizza> elementosPizzas = new ArrayList<Pizza>(pizzas.keySet());

        ArrayAdapter<Pizza> adapter = new ArrayAdapter<Pizza>(this, android.R.layout.simple_list_item_1, elementosPizzas);
        listView.setAdapter(adapter);

        tamanos = new String[]{tipoTamano.PEQUENO.toString(),tipoTamano.MEDIANO.toString(),tipoTamano.GRANDE.toString()};

        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tamanos);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pizzaSeleccionada = elementosPizzas.get(position);

            }
        });

    }
}