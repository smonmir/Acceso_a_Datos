package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pizzeria.POJO.Pizza;
import com.example.pizzeria.POJO.tipoIngrediente;
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
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_personalizada);

        servicio = Servicio.getInstance();
        pizzas = servicio.getPizzas();

        linearLayout = findViewById(R.id.linearLayout);
        spinner = findViewById(R.id.spinner);

        mostrarIngredientes();

        mostrarTamanos();
    }


    private void mostrarTamanos(){
        tamanos = new String[]{tipoTamano.PEQUENO.getTamano(),tipoTamano.MEDIANO.getTamano(),tipoTamano.GRANDE.getTamano()};

        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tamanos);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

    }

    public void mostrarIngredientes(){

        // Crea un ScrollView que contendrá los TextView
        ScrollView scrollView = new ScrollView(this);

        // Crea un LinearLayout para organizar los TextView verticalmente
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Itera sobre los valores del enum y crea un TextView para cada uno
        for (tipoIngrediente ingredient : tipoIngrediente.values()) {
            TextView textView = new TextView(this);

            // Configuración del TextView
            textView.setText(ingredient.toString()); // Muestra el nombre del ingrediente
            textView.setTextSize(30); // Tamaño del texto en sp
            textView.setPadding(8, 8, 8, 16); // Añadir relleno en píxeles

            // Configuración de márgenes entre ingredientes
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(10, 10, 10, 20); // Establecer márgenes en píxeles (arriba, izquierda, abajo, derecha)
            textView.setLayoutParams(layoutParams);

            // Agrega el TextView al LinearLayout
            linearLayout.addView(textView);
        }

        // Agrega el LinearLayout al ScrollView
        scrollView.addView(linearLayout);

        // Establece el ScrollView como el contenido de la actividad
        setContentView(scrollView);

    }

    /*
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
    */
}