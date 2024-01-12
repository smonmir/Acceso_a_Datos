package com.example.pruebamoverfiguras;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class MoverFiguras extends SurfaceView implements SurfaceHolder.Callback{

    private HiloPintar hiloPintar;
    public MoverFiguras(Context context){
        super(context);
        getHolder().addCallback(this);
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void onDraw(Canvas canvas){

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return true;
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        hiloPintar = new HiloPintar(getHolder(), this);
        hiloPintar.setRunning(true);
        hiloPintar.run();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

}
