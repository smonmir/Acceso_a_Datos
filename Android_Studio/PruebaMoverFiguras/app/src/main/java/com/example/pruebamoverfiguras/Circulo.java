package com.example.pruebamoverfiguras;

public class Circulo extends Figura{

    private float radio;

    public Circulo(float x, float y, float radio) {
        super(x, y);
        this.radio = radio;
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
}
