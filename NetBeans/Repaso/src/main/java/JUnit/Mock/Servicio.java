/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JUnit.Mock;

/**
 *
 * @author dam
 */
public class Servicio implements IServicio{

    public Servicio(){
        
    }
    
    @Override
    public int multiplicar(int a, int b) {
        return a*b;
    }

    @Override
    public int dividir(int a, int b) {
        return a/b;
    }
    
}
