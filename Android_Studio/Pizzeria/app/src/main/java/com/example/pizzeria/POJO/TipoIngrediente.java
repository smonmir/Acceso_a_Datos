package com.example.pizzeria.POJO;

public enum TipoIngrediente {

    PARMESANO("Parmesano"), MOZZARELLA("mozzarella"), BACON("Bacon"), SALSA_BARBACOA("Salsa barbacora"), QUESO_ROQUEFORT("Queso roquefort"), QUESO1("Queso1"), QUESO2("Queso2"), QUESO3("Queso3"), CHAMPINONES("champiñones"), PEPERONI("Peperoni"), SALAMI("Salami"), SALSA_PICANTE("Salsa picante"), JAMON_YORK("Jamon york"), JAMON_SERRANO("Jamon serrano"), OREGANO("Oregano"), MAIZ("Maiz"), PINA("Piña"), POLLO("Pollo"), TOMATE("Tomate");

    private String ingrediente;

    TipoIngrediente(String ingrediente){
        this.ingrediente = ingrediente;
    }

    public String getIngrediente(){
        return this.ingrediente;
    }

}
