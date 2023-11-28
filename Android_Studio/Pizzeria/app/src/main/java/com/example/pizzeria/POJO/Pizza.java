package com.example.pizzeria.POJO;

import java.util.ArrayList;
import java.util.Objects;

public class Pizza {

    private String nombre;
    private TipoTamano tamano;
    private double precio;
    private ArrayList<String> ingredientes;

    public Pizza(String nombre, ArrayList<String> ingredientes){
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }

    public Pizza(){

    }

    public String getNombre() {
        return nombre;
    }

    public TipoTamano getTamano() {
        return tamano;
    }

    public double getPrecio() {
        return precio;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTamano(TipoTamano tamano) {
        if(tamano == TipoTamano.PEQUENO){
            this.precio = 1.5;
        }
        else if(tamano == TipoTamano.MEDIANO){
            this.precio = 2.5;
        }
        else if(tamano == TipoTamano.GRANDE){
            this.precio = 3.5;
        }
        this.tamano = tamano;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Pizza= " + nombre +"\nIngredientes= " + ingredientes.toString()+"\nPrecio= "+precio+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Double.compare(pizza.precio, precio) == 0 && Objects.equals(nombre, pizza.nombre) && tamano == pizza.tamano && Objects.equals(ingredientes, pizza.ingredientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tamano, precio, ingredientes);
    }

}
