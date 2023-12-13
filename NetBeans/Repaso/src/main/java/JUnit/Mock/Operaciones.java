/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JUnit.Mock;

/**
 *
 * @author dam
 */
public class Operaciones {
    
    private IServicio servicio;
    
    public Operaciones(IServicio servicio){
        this.servicio = servicio;
    }
    
    public int multiplicar(int a, int b){
        return this.servicio.multiplicar(a, b);
    }
    
    public int dividir(int a, int b){
        return this.servicio.dividir(a, b);
    }
    
}
