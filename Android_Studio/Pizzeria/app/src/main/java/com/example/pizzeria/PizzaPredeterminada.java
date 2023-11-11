package com.example.pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
    private String pizzaSeleccionada, tamañoSeleccionado;
    private String[] tamanos;
    private Spinner spinner;
    private ListView listView;
    private Button btnAceptar, btnCancelar;
    private TextView txtPizzas, txtSeleccionarPizza, txtLista;
    private boolean modoOscuro = false;
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
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tamañoSeleccionado = (String) spinner.getSelectedItem();

                if(pizzaSeleccionada != null){
                    Intent i = new Intent(PizzaPredeterminada.this, ConfirmacionPedido.class);
                    i.putExtra("pizzaSeleccionada", pizzaSeleccionada);
                    i.putExtra("tamañoSeleccionado", tamañoSeleccionado);
                    i.putExtra("fuente", "Predeterminada");
                    startActivity(i);
                }
                else{
                    alertaIncorrecto();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    public void mostrarPizzas(Map<Pizza, Pizza> pizzas){

        ArrayList<String> listaNombrePizzas = new ArrayList<>();
        ArrayList<String> listaIngredientePizzas = new ArrayList<>();

        Iterator<Map.Entry<Pizza, Pizza>> iterator = pizzas.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Pizza, Pizza> entry = iterator.next();
            Pizza value = entry.getValue();

            List<String> ingredientes = value.getIngredientes();
            String ingredientesString = TextUtils.join(", ", ingredientes); // Combina los ingredientes con comas

            String strIngredientePizza = "Ingredientes: "+ingredientesString;
            listaIngredientePizzas.add(strIngredientePizza);

            String strNombrePizza = value.getNombre().toUpperCase(); //+ ".\nIngredientes: " + ingredientesString+".\n";
            listaNombrePizzas.add(strNombrePizza);

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaNombrePizzas) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                txtLista = view.findViewById(android.R.id.text1);

                txtLista.setTextSize(20);
                txtLista.setText(listaNombrePizzas.get(position) + "\n" + listaIngredientePizzas.get(position));

                if(modoOscuro){
                    txtLista.setTextColor(Color.WHITE);
                    txtLista.setBackgroundColor(getResources().getColor(R.color.colorFondoOn));
                }
                else{
                    txtLista.setTextColor(Color.BLACK);
                    txtLista.setBackgroundColor(getResources().getColor(R.color.colorFondoOff));
                }

                return view;
            }
        };

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPizza = listaNombrePizzas.get(position);
                pizzaSeleccionada = selectedPizza;

                if(!modoOscuro){
                    for (int i = 0; i < listView.getChildCount(); i++) {
                        if(position == i ){
                            listView.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.azulCeleste));
                        }else{
                            listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                        }
                    }
                }
                else{
                    for (int i = 0; i < listView.getChildCount(); i++) {
                        if(position == i ){
                            listView.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.grisClaro));
                        }else{
                            listView.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.colorFondoOn));
                        }
                    }
                }

            }
        });

    }


    private void alertaIncorrecto(){
        AlertDialog.Builder builder = new AlertDialog.Builder(PizzaPredeterminada.this);

        String message = "Debe seleccionar una pizza.";

        //Cambiar color de texto y alinearlo al centro
        SpannableString spannableMessage = new SpannableString(message);
        spannableMessage.setSpan(new ForegroundColorSpan(Color.WHITE), 0, message.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableMessage.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, message.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        builder.setMessage(spannableMessage);

        AlertDialog dialog = builder.create();

        //Cambiar posicion
        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        layoutParams.y = 800;

        dialog.getWindow().setAttributes(layoutParams);
        //Cambiar color de fondo
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog);

        dialog.show();

        //Tiempo de duracion del AlertDialog
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 2000);
    }

    private void spinnerTamanos(){
        tamanos = new String[]{tipoTamano.PEQUENO.getTamano(),tipoTamano.MEDIANO.getTamano(),tipoTamano.GRANDE.getTamano()};
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tamanos);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("switchModo", Context.MODE_PRIVATE);
        boolean switchState = sharedPref.getBoolean("switchColor", false);

        if (switchState) {
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorFondoOn));
            changeTextViewColor(R.color.colorFondoOff);
            modoOscuro = true;
        } else {
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorFondoOff));
            changeTextViewColor(R.color.colorFondoOn);
            modoOscuro = false;
        }
    }

    private void changeTextViewColor(int colorResId) {
        txtPizzas = findViewById(R.id.txtPizzas);
        txtSeleccionarPizza = findViewById(R.id.txtSeleccionarPizza);

        int textColor = getResources().getColor(colorResId);

        txtPizzas.setTextColor(textColor);
        txtSeleccionarPizza.setTextColor(textColor);
    }
}