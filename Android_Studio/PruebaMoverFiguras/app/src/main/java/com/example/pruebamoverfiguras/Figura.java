package com.example.pruebamoverfiguras;

public abstract class Figura {

    private float x, y;

    public Figura(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public abstract boolean hovered(float x, float y);

}
