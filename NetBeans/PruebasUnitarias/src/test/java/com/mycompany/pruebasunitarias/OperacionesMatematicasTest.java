/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.pruebasunitarias;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author dam
 */
public class OperacionesMatematicasTest {
    
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
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of sumar method, of class OperacionesMatematicas.
     */
    @Test
    public void testSumar() {
        System.out.println("sumar");
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

    /**
     * Test of restar method, of class OperacionesMatematicas.
     */
    @Test
    public void testRestar() {
        System.out.println("restar");
        int a = 3;
        int b = 3;
        OperacionesMatematicas instance = new OperacionesMatematicas();
        int expResult = 0;
        int result = instance.restar(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
