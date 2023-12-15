package com.example.pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import com.example.pizzeria.Servicio.Servicio;

import java.nio.file.attribute.FileTime;

public class Loggin extends AppCompatActivity {

    private Button btnConfirmar, btnRegistrar;
    private EditText txtUsuario, txtContrasena;
    private CheckBox recordar;
    private TextView txtViewInicioSesion, txtViewUsuario, txtViewContrasena;
    private Servicio servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtContrasena = findViewById(R.id.txtContrasena);

        recordar = findViewById(R.id.chBoxRecuerdame);

        servicio = Servicio.getInstance(this);

        recordarUsuario();

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


    private void recordarUsuario(){
        SharedPreferences sharedPreferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String clave = "usuario_"+txtUsuario.getText().toString();
        // Recuperar el nombre de usuario si se guardó previamente y establecerlo en el EditText
        String savedUsername = sharedPreferences.getString(clave, "");
        txtUsuario.setText(savedUsername);
        txtContrasena.setText("");

        //CheckBox checked si se pulso y se guardo un usuario
        if(savedUsername.length() != 0){
            recordar.setChecked(true);
        }

        recordar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Si se marca el CheckBox, guardar el nombre de usuario
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(clave, txtUsuario.getText().toString());
                editor.apply();
            } else {
                // Si se desmarca el CheckBox, borrar el nombre de usuario
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(clave);
                editor.apply();
            }
        });
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
        txtViewInicioSesion = findViewById(R.id.txtViewInicioSesion);
        txtViewUsuario = findViewById(R.id.txtViewUsuario);
        txtViewContrasena = findViewById(R.id.txtViewContrasena);

        int textColor = getResources().getColor(colorResId);
        int textColorHint =  getResources().getColor(R.color.colorHint);

        txtViewInicioSesion.setTextColor(textColor);
        txtViewUsuario.setTextColor(textColor);
        txtViewContrasena.setTextColor(textColor);
        recordar.setTextColor(textColor);
        txtUsuario.setTextColor(textColor);
        txtUsuario.setHintTextColor(textColorHint);
        txtContrasena.setTextColor(textColor);
        txtContrasena.setHintTextColor(textColorHint);
    }
}
