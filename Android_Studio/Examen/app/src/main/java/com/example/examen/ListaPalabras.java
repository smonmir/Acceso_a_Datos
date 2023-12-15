package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.examen.POJO.Palabra;
import com.example.examen.Servicio.Servicio;

import java.util.ArrayList;

public class ListaPalabras extends AppCompatActivity {

    private ListView listView;
    private TextView txtLista;
    private ArrayList<Palabra> listaPalabras;
    private Servicio servicio;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_palabras);

        servicio = Servicio.getInstance(this);

        listView = findViewById(R.id.listViewListaPalabras);

        listaPalabras = servicio.obtenerPalabras(this);

        mostrarPalabras(listaPalabras);

        btnVolver = findViewById(R.id.btnVolverListaPalabras);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void mostrarPalabras(ArrayList<Palabra> listaPalabras){

        ArrayList<Palabra> lista = listaPalabras;
        ArrayAdapter<Palabra> adapter = new ArrayAdapter<Palabra>(this, android.R.layout.simple_list_item_1, lista) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                txtLista = view.findViewById(android.R.id.text1);
                txtLista.setText(lista.get(position).getNombre());

                return view;
            }
        };
        listView.setAdapter(adapter);
    }
}