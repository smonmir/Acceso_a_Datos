/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JUnit.Mock;

/**
 *
 * @author dam
 */
public class ServicioMock implements IServicio{

    public ServicioMock(){
        
    }
    
    @Override
    public int multiplicar(int a, int b) {
        return 6;
    }

    @Override
    public int dividir(int a, int b) {
        return 2;
    }
    
}
