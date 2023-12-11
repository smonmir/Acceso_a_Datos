package POJO;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class OperacionesMatematicasTest2 {

	private OperacionesMatematicas operacionesMatematicas = new OperacionesMatematicas();;

    @Test
    public void pruebaSumar() {
        assertEquals(5, operacionesMatematicas.sumar(2, 3));
    }

    @Test
    public void pruebaRestar() {
        assertEquals(2, operacionesMatematicas.restar(5, 3));
    }

    @Test
    public void pruebaMultiplicar() {
        assertEquals(15, operacionesMatematicas.multiplicar(3, 5));
    }

    @Test
    public void pruebaDividir() {
        assertEquals(2.0, operacionesMatematicas.dividir(6, 3), 0.001);
    }

    @Test
    public void pruebaDividirPorCero() {
        // Usando assertThrows para manejar la excepción
        assertThrows(IllegalArgumentException.class, () -> {
            operacionesMatematicas.dividir(5, 0);
        });
    }
    
}
