package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class Configuracion extends AppCompatActivity {

    private Switch modo;
    private Button btnVolver;
    private TextView textViewConfigurar, textViewModoOscuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        modo = findViewById(R.id.switch1);

        btnVolver = findViewById(R.id.btnVolver);

        modo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorFondoOn));
                    changeTextViewColor(R.color.colorFondoOff);
                } else {
                    getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorFondoOff));
                    changeTextViewColor(R.color.colorFondoOn);
                }

                SharedPreferences sharedPref = getSharedPreferences("switchModo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("switchColor", isChecked);
                editor.apply();

            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("switchModo", Context.MODE_PRIVATE);
        boolean switchState = sharedPref.getBoolean("switchColor", false);

        if (switchState) {
            modo.setChecked(true);
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorFondoOn));
            changeTextViewColor(R.color.colorFondoOff);
        } else {
            modo.setChecked(false);
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorFondoOff));
            changeTextViewColor(R.color.colorFondoOn);
        }
    }

    private void changeTextViewColor(int colorResId) {
        textViewConfigurar = findViewById(R.id.textViewConfigurar);
        textViewModoOscuro = findViewById(R.id.textViewModoOscuro);

        int textColor = getResources().getColor(colorResId);

        textViewConfigurar.setTextColor(textColor);
        textViewModoOscuro.setTextColor(textColor);
    }


}