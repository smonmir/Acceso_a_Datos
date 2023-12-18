/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mockito;

/**
 *
 * @author santi
 */
public class OperacionesMatematicas {
    
    private Servicio servicio;

    public OperacionesMatematicas(Servicio servicio){
        this.servicio = servicio;
    }
    
    public int sumar(int a, int b){
        return this.servicio.sumar(a, b);
    }
    
    public int restar(int a, int b){
        return this.servicio.restar(a, b);
    }

    
}
