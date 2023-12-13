/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package JUnitMockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 *
 * @author dam
 */
public class OperacionesMatematicasTest {
    
        
    @InjectMocks
    private static OperacionesMatematicas operacionesMatematicas;
    
    @Mock
    private static Servicio servicio;
    
    
    public OperacionesMatematicasTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        //MOCKITO
        servicio = Mockito.mock(Servicio.class);
        
        operacionesMatematicas = new OperacionesMatematicas(servicio);
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    //CON MOCKITO
    
    @Test
    public void testSumar() {   
        Mockito.when(servicio.sumar(3, 2)).thenReturn(5);
        
        int resultado = operacionesMatematicas.sumar(3, 2);
        
         assertEquals(5, resultado);

    }

    @Test
    public void testRestar() {
        Mockito.when(servicio.restar(10, 5)).thenReturn(5);
        
        int resultado = operacionesMatematicas.restar(10, 5);
        
         assertEquals(5, resultado);
    }
    
    
    
}
