package com.example.pruebamoverfiguras;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class TestActivity extends Activity {
    private MoverFiguras miVista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Cambiar orientacion pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        setContentView( new MoverFiguras(this));
    }
}
