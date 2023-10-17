package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnElegirPizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnElegirPizza = findViewById(R.id.btnElegirPizza);

        btnElegirPizza.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnElegirPizza){
            //Intent i = new Intent(com.example.pizzeria.ElegirPizzeria, ElegirPizzeria);
        }
    }
}