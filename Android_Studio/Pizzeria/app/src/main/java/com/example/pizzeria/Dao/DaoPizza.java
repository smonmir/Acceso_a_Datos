package com.example.pizzeria.Dao;

import com.example.pizzeria.POJO.Pizza;
import com.example.pizzeria.POJO.TipoIngrediente;
import com.example.pizzeria.POJO.Usuario;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class DaoPizza {

    private static DaoPizza daoPizza = null;
    private Map<Pizza, Pizza> pizzas = new LinkedHashMap<Pizza, Pizza>();

    private DaoPizza(){
        Pizza pizza;
        pizza = new Pizza("Barcaboa", new ArrayList<String>(){{add(TipoIngrediente.SALSA_BARBACOA.getIngrediente());add(TipoIngrediente.QUESO_ROQUEFORT.getIngrediente());add(TipoIngrediente.TOMATE.getIngrediente());add(TipoIngrediente.BACON.getIngrediente());}});
        pizzas.put(pizza, pizza);
        pizza = new Pizza("Cuatro quesos", new ArrayList<String>(){{add(TipoIngrediente.QUESO_ROQUEFORT.getIngrediente());add(TipoIngrediente.QUESO1.getIngrediente());add(TipoIngrediente.QUESO2.getIngrediente());add(TipoIngrediente.QUESO3.getIngrediente());}});
        pizzas.put(pizza, pizza);
        pizza = new Pizza("Jamon york", new ArrayList<String>(){{add(TipoIngrediente.QUESO_ROQUEFORT.getIngrediente());add(TipoIngrediente.TOMATE.getIngrediente());add(TipoIngrediente.JAMON_YORK.getIngrediente());}});
        pizzas.put(pizza, pizza);
        pizza = new Pizza("Margarita", new ArrayList<String>(){{add(TipoIngrediente.QUESO_ROQUEFORT.getIngrediente());add(TipoIngrediente.TOMATE.getIngrediente());add(TipoIngrediente.MOZZARELLA.getIngrediente());add(TipoIngrediente.OREGANO.getIngrediente());}});
        pizzas.put(pizza, pizza);
        pizza = new Pizza("Carbonara", new ArrayList<String>(){{add(TipoIngrediente.CHAMPINONES.getIngrediente());add(TipoIngrediente.MOZZARELLA.getIngrediente());add(TipoIngrediente.BACON.getIngrediente());add(TipoIngrediente.PARMESANO.getIngrediente());}});
        pizzas.put(pizza, pizza);

    }

    public Map<Pizza, Pizza> pizzas(){
        return this.pizzas;
    }


    public static DaoPizza getInstance(){
        if(daoPizza == null){
            return daoPizza = new DaoPizza();
        }
        else{
            return daoPizza;
        }
    }



}
