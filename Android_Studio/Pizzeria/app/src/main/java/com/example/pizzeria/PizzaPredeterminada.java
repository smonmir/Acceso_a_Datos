package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzeria.POJO.Pizza;
import com.example.pizzeria.POJO.tipoTamano;
import com.example.pizzeria.Servicio.Servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PizzaPredeterminada extends AppCompatActivity {

    private Servicio servicio;
    private Map<Pizza, Pizza> pizzas;
    private String[] tamanos;
    private Spinner spinner;
    private ListView listView;
    private Button btnAceptar, btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_predeterminada);

        servicio = Servicio.getInstance();
        pizzas = servicio.getPizzas();

        spinner = findViewById(R.id.spinnerPredeterminada);
        listView = findViewById(R.id.listViewPizzas);

        btnAceptar = findViewById(R.id.btnAceptarPredeterminada);
        btnCancelar = findViewById(R.id.btnCancelarPredeterminada);

        mostrarPizzas(pizzas);

        spinnerTamanos();

    }


    public void mostrarPizzas(Map<Pizza, Pizza> pizzas){

        ArrayList<String> listaPizzas = new ArrayList<>();

        Iterator<Map.Entry<Pizza, Pizza>> iterator = pizzas.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Pizza, Pizza> entry = iterator.next();
            Pizza value = entry.getValue();

            List<String> ingredientes = value.getIngredientes();
            String ingredientesString = TextUtils.join(", ", ingredientes); // Combina los ingredientes con comas

            String StringPizza = "Pizza: " + value.getNombre() + ".\nIngredientes: " + ingredientesString;
            listaPizzas.add(StringPizza);

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaPizzas) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

                return view;
            }
        };

        listView.setAdapter(adapter);

        listView.setSelector(R.drawable.color_fondo_listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedPizza = listaPizzas.get(position);
                //Toast.makeText(getApplicationContext(), "Pizza seleccionada: " + selectedPizza, Toast.LENGTH_SHORT).show();

                //TODO

            }
        });
    }

    private void spinnerTamanos(){
        tamanos = new String[]{tipoTamano.PEQUENO.getTamano(),tipoTamano.MEDIANO.getTamano(),tipoTamano.GRANDE.getTamano()};
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tamanos);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }
}