package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String cadena = "";
    private final int MAX_CARACTERES = 45;
    private Button uno;
    private Button dos;
    private Button tres;
    private Button cuatro;
    private Button cinco;
    private Button seis;
    private Button siete;
    private Button ocho;
    private Button nueve;
    private Button cero;

    private Button suma;
    private Button resta;
    private Button multiplicacion;
    private Button division;

    private Button restablecer;
    private Button delete;
    private Button punto;
    private Button igual;

    private TextView txtVista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uno = findViewById(R.id.btnUno);
        dos = findViewById(R.id.btnDos);
        tres = findViewById(R.id.btnTres);
        cuatro = findViewById(R.id.btnCuatro);
        cinco = findViewById(R.id.btnCinco);
        seis = findViewById(R.id.btnSeis);
        siete = findViewById(R.id.btnSiete);
        ocho = findViewById(R.id.btnOcho);
        nueve = findViewById(R.id.btnNueve);
        cero = findViewById(R.id.btnCero);

        suma = findViewById(R.id.btnSuma);
        resta = findViewById(R.id.btnResta);
        multiplicacion = findViewById(R.id.btnMultiplicacion);
        division = findViewById(R.id.btnDivision);

        restablecer = findViewById(R.id.btnRestablecer);
        delete = findViewById(R.id.btnDelete);
        punto = findViewById(R.id.btnPunto);
        igual = findViewById(R.id.btnIgual);

        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);
        cero.setOnClickListener(this);

        suma.setOnClickListener(this);
        resta.setOnClickListener(this);
        multiplicacion.setOnClickListener(this);
        division.setOnClickListener(this);

        restablecer.setOnClickListener(this);
        delete.setOnClickListener(this);
        punto.setOnClickListener(this);
        igual.setOnClickListener(this);

        txtVista = findViewById(R.id.txtVista);

    }


    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnIgual){
            try {
                ExpressionBuilder expresionBuilder = new ExpressionBuilder(cadena);
                Expression exp = expresionBuilder.build();
                double resultado = exp.evaluate();
                txtVista.setText(""+resultado);
                cadena = ""+resultado;
            }
            catch (Exception e){
                txtVista.setText("Error");
                cadena = "";
            }
        }
        else{
            if(txtVista.getText().equals("Error")){
                txtVista.setText(cadena);
            }
        }
        if(cadena.length() != MAX_CARACTERES) {

            //Botones numericos
            if (view.getId() == R.id.btnUno) {
                cadena += "1";
                txtVista.setText(cadena);
            } else if (view.getId() == R.id.btnDos) {
                cadena += "2";
                txtVista.setText(cadena);
            } else if (view.getId() == R.id.btnTres) {
                cadena += "3";
                txtVista.setText(cadena);
            } else if (view.getId() == R.id.btnCuatro) {
                cadena += "4";
                txtVista.setText(cadena);
            } else if (view.getId() == R.id.btnCinco) {
                cadena += "5";
                txtVista.setText(cadena);
            } else if (view.getId() == R.id.btnSeis) {
                cadena += "6";
                txtVista.setText(cadena);
            } else if (view.getId() == R.id.btnSiete) {
                cadena += "7";
                txtVista.setText(cadena);
            } else if (view.getId() == R.id.btnOcho) {
                cadena += "8";
                txtVista.setText(cadena);
            } else if (view.getId() == R.id.btnNueve) {
                cadena += "9";
                txtVista.setText(cadena);
            } else if (view.getId() == R.id.btnCero) {
                cadena += "0";
                txtVista.setText(cadena);
            } else if (view.getId() == R.id.btnSuma) {
                if (comprobarOperador()) {
                    cadena += "+";
                    txtVista.setText(cadena);
                }
            } else if (view.getId() == R.id.btnResta) {
                if (comprobarOperador()) {
                    cadena += "-";
                    txtVista.setText(cadena);
                }
            } else if (view.getId() == R.id.btnMultiplicacion) {
                if (comprobarOperador()) {
                    cadena += "*";
                    txtVista.setText(cadena);
                }
            } else if (view.getId() == R.id.btnDivision) {
                if (comprobarOperador()) {
                    cadena += "/";
                    txtVista.setText(cadena);
                }
            }
            else if(view.getId() == R.id.btnPunto){
                if (comprobarOperador()) {
                    cadena += ".";
                    txtVista.setText(cadena);
                }
            }

        }
        if (view.getId() == R.id.btnDelete) {
            if (cadena.length() != 0) {
                cadena = cadena.substring(0, cadena.length() - 1);
                txtVista.setText(cadena);
            }
        }
        else if (view.getId() == R.id.btnRestablecer) {
            cadena = "";
            txtVista.setText(cadena);
        }

    }

    private boolean comprobarOperador(){
        boolean correcto = true;
        if(cadena.length() != 0){
            char ultCaracter = cadena.charAt(cadena.length() - 1);
            if (ultCaracter == '+' || ultCaracter == '-' || ultCaracter == '*' || ultCaracter == '/' || ultCaracter == '.') {
                correcto = false;
            }
        }
        return correcto;
    }



}