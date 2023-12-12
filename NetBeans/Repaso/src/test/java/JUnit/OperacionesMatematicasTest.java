/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package JUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author santi
 */
public class OperacionesMatematicasTest {
    
    @InjectMocks
    private static OperacionesMatematicas operacionesMatematicas;
    
    @Mock
    private static Servicio servicio;
    
    @Mock
    private static ServicioFalse servicioFalse;
    
    
    
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
        
       
        //MOCK
        /*
        servicioFalse = new ServicioFalse();
        
        operacionesMatematicas = new OperacionesMatematicas(servicioFalse);
        */
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    //PRUEBAS UNITARIAS SIN MOCK Y SIN MOCKITO
    /*
    @Test
    public void testSumar() {
        System.out.println("sumar");
        int a = 5;
        int b = 3;
        OperacionesMatematicas instance = new OperacionesMatematicas();
        int expResult = 8;
        int result = instance.sumar(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    @Test
    public void testRestar() {
        System.out.println("restar");
        int a = 0;
        int b = 0;
        OperacionesMatematicas instance = new OperacionesMatematicas();
        int expResult = 0;
        int result = instance.restar(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    */
    
    
    //CON MOCKITO
    
    @Test
    public void testSumar() {
        
        Mockito.when(servicio.sumar(3, 2)).thenReturn(5);
        
        int resultado = operacionesMatematicas.sumar(3, 2);
        
         assertEquals(5, resultado);

    }

    @Test
    public void testRestar() {
        // Crear un mock para la clase OperacionesMatematicas
        OperacionesMatematicas operacionesMock = mock(OperacionesMatematicas.class);

        // Configurar el comportamiento esperado del mock
        when(operacionesMock.restar(8, 5)).thenReturn(3);

        // Verificar que el método restar se llama con los argumentos esperados
        int resultado = operacionesMock.restar(8, 5);
        assertEquals(3, resultado);

        // Verificar que el método restar se llamó exactamente una vez con los argumentos esperados
        verify(operacionesMock, times(1)).restar(8, 5);
    }
    
    
    
    //CON MOCK
    /*
    @Test
    public void testMultiplicarExterno() {
        
        int resultado = operacionesMatematicas.multiplicar(3, 2);
        
         assertEquals(5, resultado);
    }
    */
    
    
}
