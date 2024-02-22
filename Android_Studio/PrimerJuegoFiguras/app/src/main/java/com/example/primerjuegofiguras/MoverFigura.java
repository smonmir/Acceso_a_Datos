package com.example.primerjuegofiguras;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MoverFigura extends SurfaceView implements SurfaceHolder.Callback {
    private Paint paint;
    private HiloPintar hiloPintar;
    private ArrayList<Figura> circulos, rectangulos;
    private Circulo circulo, circuloVacio;
    private Rectangulo rectangulo, rectanguloVacio, btnRectangulo;
    private boolean circuloSeleccionado, existeFigura;

    public MoverFigura(Context context){
        super(context);
        paint = new Paint();
        circulos = new ArrayList<Figura>();
        rectangulos = new ArrayList<Figura>();

        circulo = new Circulo(200, 300, 150);
        circuloVacio = new Circulo(900, 300, 150);

        rectangulo = new Rectangulo(350, 700, 50, 900);
        rectanguloVacio = new Rectangulo(1050, 700, 750, 900);

        btnRectangulo =  new Rectangulo(750, 1800, 350, 2000);

        setBackgroundColor(Color.BLACK);

        circuloSeleccionado = true;
        existeFigura = false;

        getHolder().addCallback(this);
    }
    @Override
    public void onDraw(Canvas canvas){

        paint.setAntiAlias(true);
        canvas.drawColor(Color.WHITE);


        for (Figura figura : rectangulos) {
            paint.setColor(Color.BLACK);
            canvas.drawRect(rectanguloVacio.getX(), rectanguloVacio.getY(), rectanguloVacio.getAncho(), rectanguloVacio.getAlto(), paint);
            paint.setColor(Color.BLUE);
            canvas.drawRect(rectangulo.getX(), rectangulo.getY(), rectangulo.getAncho(), rectangulo.getAlto(), paint);
        }

        for (Figura figura : circulos) {
            paint.setColor(Color.BLACK);
            canvas.drawCircle(circuloVacio.getX(), circuloVacio.getY(), circuloVacio.getRadio(), paint);
            paint.setColor(Color.BLUE);
            canvas.drawCircle(circulo.getX(), circulo.getY(), circulo.getRadio(), paint);
        }


        paint.setColor(Color.RED);
        canvas.drawRect(btnRectangulo.getX(), btnRectangulo.getY(), btnRectangulo.getAncho(), btnRectangulo.getAlto(), paint);


        invalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                if(event.getX() <= rectangulo.getX() &&
                        event.getX() >= rectangulo.getAncho() &&
                        event.getY() >= rectangulo.getY() &&
                        event.getY() <= rectangulo.getAlto()){

                    //rectangulo = new Rectangulo(350, 700, 50, 900);

                    float nuevoX = (rectangulo.getX() + (event.getX() - rectangulo.getX())) + 150;
                    float nuevoY = (rectangulo.getY() + (event.getY() - rectangulo.getY())) + 100;

                    float nuevoAncho = rectangulo.getAncho() + (event.getX() - rectangulo.getAncho()) - 150;
                    float nuevoAlto = rectangulo.getAlto() + (event.getY() - rectangulo.getAlto()) - 100;

                    rectangulo.setX(nuevoX);
                    rectangulo.setY(nuevoY);
                    rectangulo.setAncho(nuevoAncho);
                    rectangulo.setAlto(nuevoAlto);
                }


                if(event.getX() >= circulo.getX() - (circulo.getRadio() + circulo.getX())  &&
                    event.getX() <=  circulo.getX() + circulo.getRadio() &&
                    event.getY() >= circulo.getY() - (circulo.getRadio() + circulo.getY()) &&
                    event.getY() <= circulo.getY() + circulo.getRadio()){

                        circulo.setX(event.getX());
                        circulo.setY(event.getY());

                        if(circuloVacio.umbral(event.getX(), event.getY())){
                            circulo.setX(circuloVacio.getX());
                            circulo.setY(circuloVacio.getY());

                            for (int i = 0; i < circulos.size(); i++) {
                                    circulos.remove(i);
                            }


                        }

                }
                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                float y = event.getY();
                float x = event.getX();
                if(event.getX() <= btnRectangulo.getX() &&
                        event.getX() >= btnRectangulo.getAncho() &&
                        event.getY() >= btnRectangulo.getY() &&
                        event.getY() <= btnRectangulo.getAlto()){

                    generarRectangulo();

                        if(!existeFigura){
                            generarCirculo();
                            existeFigura = true;
                        }
                        else {
                            generarRectangulo();
                            existeFigura = false;
                        }

                    invalidate();

                }
                break;
        }
        return true;
    }

    private void generarCirculo(){

        this.circulo = new Circulo(200, 300, 150);
        this.circuloVacio = new Circulo(900, 300, 150);
        circulos.add(circulo);
        circulos.add((circuloVacio));


    }


    private void generarRectangulo(){
        rectangulo = new Rectangulo(350, 700, 50, 900);
        rectanguloVacio = new Rectangulo(1050, 700, 750, 900);
        rectangulos.add(rectangulo);
        rectangulos.add((rectanguloVacio));
    }



    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        hiloPintar = new HiloPintar(getHolder(), this);
        hiloPintar.setRunning(true);
        hiloPintar.start();

        /*
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.imagen);
        Bitmap img = bmp.createScaledBitmap(bmp, getWidth() * 0.2, getHeight() * 0.2, true);
        Canvas.drawBitmap(img, posx, posy, null);
        */
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
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