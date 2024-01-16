package com.example.pruebamoverfiguras;

public class Rectangulo extends Figura{

    private float ancho, alto;

    public Rectangulo(float x, float y, float ancho, float alto) {
        super(x, y);
        this.ancho = ancho;
        this.alto = alto;
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
        if(x >= this.getX() && x<= this.getX() + ancho && y >= this.getY() && y <= this.getY() + alto){
            return true;
        }
        return false;
    }
}
