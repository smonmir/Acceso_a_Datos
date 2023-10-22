package com.example.pizzeria.Dao;

import com.example.pizzeria.POJO.Pizza;
import com.example.pizzeria.POJO.Usuario;

import java.util.LinkedHashMap;
import java.util.Map;

public class DaoUsuario {

    private static DaoUsuario daoUsuario = null;

    private Map<Usuario, Usuario> usuarios = new LinkedHashMap<Usuario, Usuario>();

    private DaoUsuario(){

        Usuario usuario;
        usuario = new Usuario("admin", "admin");
        usuarios.put(usuario, usuario);

    }

    public Map<Usuario, Usuario> getUsuarios() {
        return usuarios;
    }


    public static DaoUsuario getInstance(){
        if(daoUsuario == null){
            return daoUsuario = new DaoUsuario();
        }
        else{
            return daoUsuario;
        }
    }


}


