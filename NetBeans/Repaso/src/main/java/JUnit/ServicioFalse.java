/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JUnit;

/**
 *
 * @author santi
 */
public class ServicioFalse implements CalculadoraExterna{

    public ServicioFalse(){
        
    }
    
    @Override
    public int multiplicar(int a, int b) {
        return 6;
    }
    
}
