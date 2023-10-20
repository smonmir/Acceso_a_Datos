package com.example.pizzeria.POJO;

public enum tipoTamano {

    PEQUENO("Pequeño"), MEDIANO("Mediano"), GRANDE("Grande");

    private String tamano;
    tipoTamano(String tamano){
        this.tamano = tamano;
    }

    public String getTamano(){
        return tamano;
    }

}
