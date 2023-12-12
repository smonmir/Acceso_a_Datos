/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.piscina;

import java.io.IOException;
import java.security.MessageDigest;

/**
 *
 * @author dam
 */
public class Piscina {

    private int nivel;
    public final double MAX_NIVEL;
    
    public Piscina(double max){
        if(max<0) max=0;
        MAX_NIVEL = max;
    }
    
    public int getNivel(){
        return nivel;
    }
    
    public void vaciar(int cantidad) throws IOException{
        
        if(nivel-cantidad<0){
             throw new IOException("El nivel no puede quedar por debajo de cero.");
        }
        else{
            nivel=nivel-cantidad;
        }
        
    }
    
    public void llenar(int cantidad) throws IOException{

        if (nivel + cantidad > MAX_NIVEL) {
            throw new IOException("El nivel no puede quedar por encima del máximo.");
        } else {
            nivel = nivel + cantidad;
        }
    }
    
    
}
