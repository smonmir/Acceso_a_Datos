/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package JUnit.Mock;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 *
 * @author dam
 */
public class OperacionesTest {
    
    @InjectMocks
    private Operaciones operaciones;
    
    @Mock
    private ServicioMock servicioMock;
    
    
    public OperacionesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        servicioMock = new ServicioMock();
        
        operaciones = new Operaciones(servicioMock);
    }
    
    @AfterEach
    public void tearDown() {
    }


    @Test
    public void testMultiplicar() {
        int result = operaciones.multiplicar(3, 2);
        
        assertEquals(6, result);
    }


    @Test
    public void testDividir() {
        int result = operaciones.dividir(10, 5);
        
        assertEquals(2, result);
        
    }
    
}
