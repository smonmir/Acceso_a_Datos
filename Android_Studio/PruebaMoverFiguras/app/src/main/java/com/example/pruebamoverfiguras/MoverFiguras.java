package com.example.pruebamoverfiguras;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class MoverFiguras extends SurfaceView implements SurfaceHolder.Callback{

    public MoverFiguras(Context context){
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void onDraw(Canvas canvas){

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return false;
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }
}
