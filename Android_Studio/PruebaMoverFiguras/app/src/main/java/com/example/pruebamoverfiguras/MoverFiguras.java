package com.example.pruebamoverfiguras;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MoverFiguras extends SurfaceView implements SurfaceHolder.Callback{

    private HiloPintar hiloPintar;
    private Paint paint;
    private Rectangulo rectangulo;
    private Circulo circulo;
    private boolean encimaRectangulo = false;
    private boolean encimaCirculo= false;
    private float iniX, iniY;
    private ArrayList<Figura> figura;

    public MoverFiguras(Context context){
        super(context);
        figura = new ArrayList<Figura>();
        rectangulo = new Rectangulo(100, 100, 200, 300);
        figura.add(rectangulo);
        circulo = new Circulo(500, 500, 80);
        figura.add(circulo);
        paint = new Paint();

        //getHolder().addCallback(this);
        setBackgroundColor(Color.BLACK);

    }

    @Override
    public void onDraw(Canvas canvas){
        paint.setAntiAlias(true);
        canvas.drawColor(Color.WHITE);

        paint.setColor(Color.BLUE);
        canvas.drawCircle(circulo.getX(), circulo.getY(), circulo.getRadio(), paint);

        paint.setColor(Color.RED);
        canvas.drawRect(rectangulo.getX(), rectangulo.getY(), rectangulo.getX()+rectangulo.getAncho(), rectangulo.getY()+rectangulo.getAncho(), paint);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(rectangulo.hovered(event.getX(), event.getY())){
                    encimaRectangulo = true;
                    iniX = event.getX();
                    iniY = event.getY();
                }
                if(circulo.hovered(event.getX(), event.getY())){
                    encimaCirculo = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(encimaRectangulo){
                    rectangulo.setX(rectangulo.getX()-iniX+event.getX());
                    rectangulo.setY(rectangulo.getY()-iniY+event.getY());
                    iniX = event.getX();
                    iniY = event.getY();
                }
                if(encimaCirculo){
                    circulo.setX(event.getX());
                    circulo.setY(event.getY());
                }
                break;
            case MotionEvent.ACTION_CANCEL:

                break;
            case MotionEvent.ACTION_UP:
                encimaRectangulo = false;
                encimaCirculo = false;
                break;
        }
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
        boolean retry = true;

        hiloPintar.setRunning(false);

        while(retry){
            try{
                hiloPintar.join();
                retry = false;
            }
            catch (InterruptedException e){

            }
        }
    }

}
