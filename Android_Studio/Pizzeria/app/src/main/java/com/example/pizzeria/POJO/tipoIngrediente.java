package com.example.pizzeria.POJO;

public enum tipoIngrediente {

    SALSA_BARBACOA("Salsa barbacora"), QUESO_ROQUEFORT("Queso roquefort"), CHAMPINONES("champiñones"), PEPERONI("Peperoni"), SALAMI("Salami"), SALSA_PICANTE("Salsa picante"), JAMON_YORK("Jamon york"), JAMON_SERRANO("Jamon serrano"), OREGANO("Oregano"), MAIZ("Maiz"), PINA("Piña"), POLLO("Pollo");

    private String ingrediente;

    tipoIngrediente(String ingrediente){
        this.ingrediente = ingrediente;
    }

    public String getIngrediente(){
        return this.ingrediente;
    }

}
