package com.example.pizzeria.POJO;

import java.util.ArrayList;
import java.util.Objects;

public class Pizza {

    private String nombre;
    private tipoTamano tamano;
    private double precio;
    private ArrayList<String> ingredientes;
    private boolean ingredienteExtra;

    public Pizza(String nombre, ArrayList<String> ingredientes){
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.ingredienteExtra = false;
        this.precio = ingredientes.size()*2;
    }

    public Pizza(){

    }

    public String getNombre() {
        return nombre;
    }

    public tipoTamano getTamano() {
        return tamano;
    }

    public double getPrecio() {
        return precio;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public boolean isIngredienteExtra() {
        return ingredienteExtra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTamano(tipoTamano tamano) {
        if(tamano == tipoTamano.PEQUENO){
            this.precio = 4.5;
        }
        else if(tamano == tipoTamano.MEDIANO){
            this.precio = 6.5;
        }
        else if(tamano == tipoTamano.GRANDE){
            this.precio = 8.5;
        }
        this.tamano = tamano;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setIngredienteExtra(boolean ingredienteExtra) {
        this.ingredienteExtra = ingredienteExtra;
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
        return Double.compare(pizza.precio, precio) == 0 && ingredienteExtra == pizza.ingredienteExtra && Objects.equals(nombre, pizza.nombre) && tamano == pizza.tamano && Objects.equals(ingredientes, pizza.ingredientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tamano, precio, ingredientes, ingredienteExtra);
    }

}
