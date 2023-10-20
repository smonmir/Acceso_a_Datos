package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Loggin extends AppCompatActivity {

    private Button btnConfirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        btnConfirmar = findViewById(R.id.btnConfirmar);

        //TODO
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                Intent i = new Intent(Loggin.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}