package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pizzeria.POJO.Pizza;
import com.example.pizzeria.POJO.TipoTamano;
import com.example.pizzeria.Servicio.Servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PizzaPersonalizada extends AppCompatActivity{

    private Servicio servicio;
    private Map<Pizza, Pizza> pizzas;
    private Map<String, Integer> cantidadesIngredientes = new HashMap<>();
    private Pizza pizzaSeleccionada;
    private String[] tamanos;
    private Spinner spinnerTamanos, spinnerPizzas, spinnerIngredientes;
    private Button btnIncrementar, btnDecrementar, btnAceptar, btnCanelar;
    private TextView txtViewPizza, txtViewIngredientes, txtViewCantidad, cantidadIngredienteTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_personalizada);

        servicio = Servicio.getInstance();
        pizzas = servicio.getPizzas();

        spinnerTamanos = findViewById(R.id.spinnerTamanos);
        spinnerPizzas = findViewById(R.id.spinnerPizzas);
        spinnerIngredientes = findViewById(R.id.spinnerIngredientes);

        btnIncrementar = findViewById(R.id.btnIncrementar);
        btnDecrementar = findViewById(R.id.btnDecrementar);

        btnAceptar = findViewById(R.id.btnAceptar);
        btnCanelar = findViewById(R.id.btnCancelar2);

        mostrarPizzas();
        mostrarTamanos();

        btnIncrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementarCantidadIngrediente();
            }
        });


        btnDecrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementarCantidadIngrediente();
            }
        });


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrePizza = pizzaSeleccionada.getNombre();
                String tamano =  spinnerTamanos.getSelectedItem().toString();

                int cantIngredientes = sumaCantIngrediente();

                String precio = pizzaSeleccionada.getPrecio()+"";

                Intent i = new Intent(PizzaPersonalizada.this, ConfirmacionPedido.class);

                i.putExtra("nombrePizza", nombrePizza);
                i.putExtra("tamano", tamano);
                i.putExtra("cantIngredientes", cantIngredientes+"");
                i.putExtra("fuente", "PersoPizza");

                startActivity(i);
            }
        });


        btnCanelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private Integer sumaCantIngrediente(){
        int cantidad = 0;

        Iterator<Map.Entry<String, Integer>> iterator = cantidadesIngredientes.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            Integer value = entry.getValue();

            cantidad += value;
        }

        return cantidad;
    }

    private void mostrarTamanos(){
        tamanos = new String[]{TipoTamano.PEQUENO.getTamano(), TipoTamano.MEDIANO.getTamano(), TipoTamano.GRANDE.getTamano()};

        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tamanos);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTamanos.setAdapter(spinnerAdapter);
    }

    private void mostrarPizzas() {
        List<Pizza> listaDePizzas = new ArrayList<>(pizzas.keySet());

        PizzaAdapter adapter = new PizzaAdapter(this, android.R.layout.simple_spinner_item, listaDePizzas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPizzas.setAdapter(adapter);
        spinnerPizzas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                pizzaSeleccionada = listaDePizzas.get(position);
                mostrarIngredientes();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

    }

    public void mostrarIngredientes(){
        List<String> ingredientesDisponibles = pizzaSeleccionada.getIngredientes();
        ArrayAdapter<String> ingredientesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ingredientesDisponibles);
        ingredientesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIngredientes.setAdapter(ingredientesAdapter);

        spinnerIngredientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                actualizarCantidadTextView();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });


    }

    private void incrementarCantidadIngrediente() {
        spinnerPizzas.setEnabled(false);
        if (pizzaSeleccionada != null) {
            String ingredienteSeleccionado = spinnerIngredientes.getSelectedItem().toString();

            int cantidadActual = cantidadesIngredientes.getOrDefault(ingredienteSeleccionado, 0);
            cantidadesIngredientes.put(ingredienteSeleccionado, cantidadActual + 1);

            actualizarCantidadTextView();
        }
    }

    private void decrementarCantidadIngrediente() {
        if (pizzaSeleccionada != null) {
            String ingredienteSeleccionado = spinnerIngredientes.getSelectedItem().toString();

            int cantidadActual = cantidadesIngredientes.getOrDefault(ingredienteSeleccionado, 0);

            if (cantidadActual > 0) {
                cantidadesIngredientes.put(ingredienteSeleccionado, cantidadActual - 1);
                actualizarCantidadTextView();
            }
        }
    }

    private void actualizarCantidadTextView() {
        cantidadIngredienteTextView = findViewById(R.id.cantidadIngredienteTextView);

        if (pizzaSeleccionada != null) {
            String ingredienteSeleccionado = spinnerIngredientes.getSelectedItem().toString();
            int cantidadActual = cantidadesIngredientes.getOrDefault(ingredienteSeleccionado, 0);
            cantidadIngredienteTextView.setText(""+cantidadActual);
        }
    }


    //Adapter para spinner de pizzas
    private class PizzaAdapter extends ArrayAdapter<Pizza> {
        public PizzaAdapter(Context context, int resource, List<Pizza> pizzas) {
            super(context, resource, pizzas);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = (TextView) super.getView(position, convertView, parent);
            textView.setText(getItem(position).getNombre());
            return textView;
        }
        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            TextView textView = (TextView) super.getDropDownView(position, convertView, parent);
            textView.setText(getItem(position).getNombre());
            return textView;
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
        txtViewPizza = findViewById(R.id.txtViewPizza);
        txtViewIngredientes = findViewById(R.id.txtViewIngredientes);
        txtViewCantidad = findViewById(R.id.txtViewCantidad);
        cantidadIngredienteTextView = findViewById(R.id.cantidadIngredienteTextView);

        int textColor = getResources().getColor(colorResId);

        spinnerTamanos.setBackgroundColor(getResources().getColor(R.color.colorFondoOff));
        spinnerPizzas.setBackgroundColor(getResources().getColor(R.color.colorFondoOff));
        spinnerIngredientes.setBackgroundColor(getResources().getColor(R.color.colorFondoOff));
        txtViewPizza.setTextColor(textColor);
        txtViewIngredientes.setTextColor(textColor);
        txtViewCantidad.setTextColor(textColor);
        cantidadIngredienteTextView.setTextColor(textColor);
    }
}