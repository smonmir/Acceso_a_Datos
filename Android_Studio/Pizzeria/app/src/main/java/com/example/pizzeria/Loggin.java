package com.example.pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import com.example.pizzeria.Servicio.Servicio;

import java.nio.file.attribute.FileTime;

public class Loggin extends AppCompatActivity {

    private Button btnConfirmar;
    private Button btnRegistrar;

    private EditText txtUsuario;
    private EditText txtContrasena;
    private Servicio servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnRegistrar = findViewById(R.id.btnRegistrar);

        txtUsuario = findViewById(R.id.txtUsuario);

        txtContrasena = findViewById(R.id.txtContrasena);

        servicio = Servicio.getInstance();

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(servicio.comprobarUsuario(txtUsuario.getText().toString(), txtContrasena.getText().toString())){
                    Intent i = new Intent(Loggin.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    alertaIncorrecto();
                }
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Loggin.this, Registro.class);
                startActivity(i);
            }
        });
    }

    private void alertaIncorrecto(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Loggin.this);

        String message = "Usuario o contraseña incorrecto.";

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
}
