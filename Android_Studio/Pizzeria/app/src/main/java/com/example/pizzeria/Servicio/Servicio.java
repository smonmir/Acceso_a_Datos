package com.example.pizzeria.Servicio;

import com.example.pizzeria.Dao.DaoPizza;
import com.example.pizzeria.POJO.Pizza;

import java.util.Map;

public class Servicio {

    private static Servicio servicio = null;
    private Map<Pizza, Pizza> pizzas;


    private Servicio(){
        pizzas = DaoPizza.getInstance().pizzas();
    }

    public Map<Pizza, Pizza> getPizzas(){
        return pizzas;
    }

    public static Servicio getInstance(){
        if(servicio == null){
            return servicio = new Servicio();
        }
        else{
            return servicio;
        }
    }



}
