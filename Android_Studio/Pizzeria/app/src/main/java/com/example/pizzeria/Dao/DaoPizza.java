package com.example.pizzeria.Dao;

import com.example.pizzeria.POJO.Pizza;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class DaoPizza {

    private static DaoPizza daoPizza = null;
    private Map<Pizza, Pizza> pizzas = new LinkedHashMap<Pizza, Pizza>();

    private DaoPizza(){
        Pizza pizza;
        pizza = new Pizza("Barcaboa", new ArrayList<String>(){{add("Salsa barbacoa");add("Queso");add("Tomate");add("Bacon");}});
        pizzas.put(pizza, pizza);

        pizza = new Pizza("Cuatro quesos", new ArrayList<String>(){{add("Queso1");add("Queso2");add("Queso3");add("Queso4");}});
        pizzas.put(pizza, pizza);

        pizza = new Pizza("Jamon york", new ArrayList<String>(){{add("Queso");add("Tomate");add("Jamon york");}});
        pizzas.put(pizza, pizza);

    }

    public Map<Pizza, Pizza> pizzas(){
        return this.pizzas;
    }


    public static DaoPizza getInstance(){
        if(daoPizza == null){
            return new DaoPizza();
        }
        else{
            return daoPizza;
        }
    }



}
