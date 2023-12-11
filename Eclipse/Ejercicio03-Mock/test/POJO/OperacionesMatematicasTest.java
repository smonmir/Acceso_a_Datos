package POJO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Interfaces.OperacionDAO;


class OperacionesMatematicasTest {
	
	private OperacionesMatematicas operacionesMatematicas;
    private OperacionDAO mockOperacionDAO;


    @BeforeEach
    public void setUp() {
        // Crear el mock del OperacionDAO
        mockOperacionDAO = mock(OperacionDAO.class);

        // Inicializar la clase que estamos probando con el mock
    	operacionesMatematicas = new OperacionesMatematicas(mockOperacionDAO);
    	
    }

    @Test
    public void pruebaSumar() {
        // Configurar el comportamiento esperado del mock
        doNothing().when(mockOperacionDAO).guardarOperacion("");

        // Ejecutar el método que estamos probando
        int resultado = operacionesMatematicas.sumar(2, 3);

        // Verificar que el resultado es el esperado
        assertEquals(5, resultado);

        // Verificar que el método del mock fue llamado con los argumentos correctos
        verify(mockOperacionDAO).guardarOperacion("Suma: 2 + 3 = 5");
    }

    /*
    @Test
    public void pruebaRestar() {
        // Configurar el comportamiento esperado del mock
        //doNothing().when(mockOperacionDAO).guardarOperacion(anyString());

        // Ejecutar el método que estamos probando
        int resultado = operacionesMatematicas.restar(5, 3);

        // Verificar que el resultado es el esperado
        assertEquals(2, resultado);

        // Verificar que el método del mock fue llamado con los argumentos correctos
        verify(mockOperacionDAO).guardarOperacion("Resta: 5 - 3 = 2");
    }

    @Test
    public void pruebaMultiplicar() {
        // Configurar el comportamiento esperado del mock
        //doNothing().when(mockOperacionDAO).guardarOperacion(anyString());

        // Ejecutar el método que estamos probando
        int resultado = operacionesMatematicas.multiplicar(4, 5);

        // Verificar que el resultado es el esperado
        assertEquals(20, resultado);

        // Verificar que el método del mock fue llamado con los argumentos correctos
        verify(mockOperacionDAO).guardarOperacion("Multiplicación: 4 * 5 = 20");
    }

    @Test
    public void pruebaDividir() {
        // Configurar el comportamiento esperado del mock
        //doNothing().when(mockOperacionDAO).guardarOperacion(anyString());

        // Ejecutar el método que estamos probando
        double resultado = operacionesMatematicas.dividir(10, 2);

        // Verificar que el resultado es el esperado
        assertEquals(5.0, resultado);

        // Verificar que el método del mock fue llamado con los argumentos correctos
        verify(mockOperacionDAO).guardarOperacion("División: 10.0 / 2.0 = 5.0");
    }
    */
}
