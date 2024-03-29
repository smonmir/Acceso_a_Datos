package com.example.moverfigurahuecovacio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MoverFigura extends SurfaceView implements SurfaceHolder.Callback {
    private Paint paint;
    private HiloPintar hiloPintar;
    private ArrayList<Figura> figuras;
    private Circulo circulo, circuloVacio;
    private Rectangulo rectangulo, rectanguloVacio;
    private Button boton;

    public MoverFigura(Context context){
        super(context);
        paint = new Paint();
        figuras = new ArrayList<Figura>();

        circulo = new Circulo(200, 300, 150);
        circuloVacio = new Circulo(900, 300, 150);
        figuras.add(circulo);

        rectangulo = new Rectangulo(350, 700, 50, 900);
        rectanguloVacio = new Rectangulo(1050, 700, 750, 900);

        boton = new Button(context);
        boton.setText("Pulsar");
        boton.setX(100);
        boton.setY(100);

        setBackgroundColor(Color.BLACK);


    }
    @Override
    public void onDraw(Canvas canvas){

        paint.setAntiAlias(true);
        canvas.drawColor(Color.WHITE);

        
        paint.setColor(Color.BLACK);
        canvas.drawCircle(circuloVacio.getX(), circuloVacio.getY(), circuloVacio.getRadio(), paint);

        paint.setColor(Color.BLUE);
        canvas.drawCircle(circulo.getX(), circulo.getY(), circulo.getRadio(), paint);

        paint.setColor(Color.BLUE);
        canvas.drawRect(rectangulo.getX(), rectangulo.getY(), rectangulo.getAncho(), rectangulo.getAlto(), paint);

        paint.setColor(Color.BLUE);
        canvas.drawRect(rectanguloVacio.getX(), rectanguloVacio.getY(), rectanguloVacio.getAncho(), rectanguloVacio.getAlto(), paint);



        invalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                circulo.setX(event.getX());
                circulo.setY(event.getY());
                if(circuloVacio.umbral(event.getX(), event.getY())){
                    circulo.setX(circuloVacio.getX());
                    circulo.setY(circuloVacio.getY());
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
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
