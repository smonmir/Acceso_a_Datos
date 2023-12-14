package com.example.pizzeria.Servicio;

import android.content.Context;
import android.text.TextUtils;

import com.example.pizzeria.Dao.DaoPizza;
import com.example.pizzeria.Dao.DaoUsuario;
import com.example.pizzeria.POJO.Pizza;
import com.example.pizzeria.POJO.Usuario;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Servicio {

    private static Servicio servicio = null;
    private Map<Pizza, Pizza> pizzas;
    private Map<Usuario, Usuario> usuarios;

    private Context context;
    private Servicio(Context context){
        this.context = context;
        pizzas = DaoPizza.pizzas(context);
    }

    public Map<Pizza, Pizza> getPizzas(){
        return pizzas;
    }

    public Map<Usuario, Usuario> getUsuarios() {return usuarios;}


    public void anadirUsuario(String usuario, String contrasena){
        DaoUsuario.insertarUsuario(context, usuario, contrasena);
    }

    public boolean comprobarUsuario(String nombre, String contrasena){
        usuarios = DaoUsuario.getUsuarios(context);
        boolean existe = false;
        Iterator<Map.Entry<Usuario, Usuario>> iterator = usuarios.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Usuario, Usuario> entry = iterator.next();
            Usuario key = entry.getKey();
            Usuario value = entry.getValue();

            if (value.getNombre().equals(nombre) && value.getContrasena().equals(contrasena)){
                existe = true;
            }
        }
        return existe;
    }

    public void setContext(Context context){
        this.context = context;
    }

    public static Servicio getInstance(Context context){
        if(servicio == null){
            return servicio = new Servicio(context);
        }
        else{
            servicio.setContext(context);
            return servicio;
        }
    }



}
