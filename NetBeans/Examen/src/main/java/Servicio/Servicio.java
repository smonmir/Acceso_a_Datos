/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import DAOS.DAOComunidad;
import DAOS.DAOVivienda;
import POJO.Comunidad;
import POJO.Vivienda;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author dam
 */
public class Servicio {
    
    private static Servicio servicio = null;
    private DAOVivienda daoVivienda;
    private DAOComunidad daoComunidad;
    
    private Servicio(){
        daoVivienda = DAOVivienda.getInstance();
        daoComunidad = DAOComunidad.getInstance();
    }

    
    public void anadirVivienda(String piso, String letra, String tarifa, String propietario, String codigoComunidad, String moroso){
        
        boolean esMoroso = false;
        
        if(moroso.equalsIgnoreCase("si")){
            esMoroso = true;
        }
     
        Vivienda vivienda = new Vivienda(Integer.parseInt(piso), letra, propietario, Integer.parseInt(tarifa), Integer.parseInt(codigoComunidad), esMoroso);
        
        daoVivienda.anadir(vivienda);
        
    }
    
    public void eliminarComunidad(int codigoComunidad){
        daoVivienda.eliminarViviendas(codigoComunidad);
        daoComunidad.eliminarComunidad(codigoComunidad);
        
    }
    

    public List<Comunidad> getComunidades(){
      
        List<Comunidad> listaComunidades = daoComunidad.getComunidades();
        
        return listaComunidades;
    }
    
    
    public List<Vivienda> getViviendas(int codigoComunidad){
      
        List<Vivienda> listaViviendas = daoVivienda.getViviendas(codigoComunidad);
        
        return listaViviendas;
    }
    
    
    public boolean comprobarMorosos(int codigoComunidad){
        
        boolean existeMoroso = false;
        
        List<Vivienda> listaViviendas = daoVivienda.getViviendas(codigoComunidad);
        
        for(Vivienda vivienda:listaViviendas){
        
            if(vivienda.isMoroso()){
                existeMoroso = true;
            }
        }
        return existeMoroso;
    }
    
    
    
    public static Servicio getInstance(){
        if(servicio == null){
            return servicio = new Servicio();
        }
        return servicio;
    }
    
}
