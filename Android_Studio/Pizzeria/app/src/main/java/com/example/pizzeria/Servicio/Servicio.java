package com.example.pizzeria.Servicio;

import com.example.pizzeria.Dao.DaoPizza;
import com.example.pizzeria.POJO.Pizza;

import java.util.Map;

public class Servicio {

    private Map<Pizza, Pizza> pizzas;

    public Servicio(){
        pizzas = DaoPizza.getInstance().pizzas();
    }



}
