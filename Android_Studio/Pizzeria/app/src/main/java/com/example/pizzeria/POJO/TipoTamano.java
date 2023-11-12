package com.example.pizzeria.POJO;

public enum TipoTamano {

    PEQUENO("Pequeño"), MEDIANO("Mediano"), GRANDE("Grande");

    private String tamano;
    TipoTamano(String tamano){
        this.tamano = tamano;
    }

    public String getTamano(){
        return tamano;
    }

}
