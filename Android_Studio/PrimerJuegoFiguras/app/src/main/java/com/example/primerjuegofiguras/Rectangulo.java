package com.example.primerjuegofiguras;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Rectangulo extends Figura{

    private float ancho, alto, x, y;
    public Rectangulo(float x, float y, float ancho, float alto) {
        super(x, y);
        this.alto = alto;
        this.ancho = ancho;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    @Override
    public boolean hovered(float x, float y) {
        return false;
    }

    public boolean umbral(float x, float y){
        int umbralX = 75;
        int umbralY = 75;

        if(x <= this.getX()+getAncho()-umbralX && x >= this.getX()-getAncho()+umbralX && y <= this.getY()+getAlto()-umbralY && y >= this.getY()-getAlto()+umbralY){
            return true;
        }
        return false;
    }

    @Override
    public void dibujar(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLUE);
        canvas.drawRect(x, y, x + ancho, y + alto, paint);
    }
}
