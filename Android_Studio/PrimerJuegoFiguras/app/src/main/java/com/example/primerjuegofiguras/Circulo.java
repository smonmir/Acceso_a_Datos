package com.example.primerjuegofiguras;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circulo extends Figura{

    private float radio, x, y;

    public Circulo(float x, float y, float radio){
        super(x, y);
        this.radio = radio;
        this.x = x;
        this.y = y;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }


    @Override
    public boolean hovered(float x, float y) {
        if(x <= this.getX()+getRadio() && x >= this.getX()-getRadio() && y <= this.getY()+getRadio() && y >= this.getY()-getRadio()){
            return true;
        }
        return false;
    }

    public boolean umbral(float x, float y){
        int umbralX = 75;
        int umbralY = 75;

        if(x <= this.getX()+getRadio()-umbralX && x >= this.getX()-getRadio()+umbralX && y <= this.getY()+getRadio()-umbralY && y >= this.getY()-getRadio()+umbralY){
            return true;
        }
        return false;
    }

}
