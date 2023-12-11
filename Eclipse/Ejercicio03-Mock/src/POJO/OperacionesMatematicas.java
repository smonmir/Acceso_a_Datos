package POJO;

import Interfaces.OperacionDAO;

public class OperacionesMatematicas {
	
	private OperacionDAO operacionDAO;

    public OperacionesMatematicas(OperacionDAO operacionDAO) {
        this.operacionDAO = operacionDAO;
    }
    

    public int sumar(int a, int b) {
        int resultado = a + b;
        operacionDAO.guardarOperacion("Suma: " + a + " + " + b + " = " + resultado);
        return resultado;
    }

    public int restar(int a, int b) {
        int resultado = a - b;
        operacionDAO.guardarOperacion("Resta: " + a + " - " + b + " = " + resultado);
        return resultado;
    }

    public int multiplicar(int a, int b) {
        int resultado = a * b;
        operacionDAO.guardarOperacion("Multiplicación: " + a + " * " + b + " = " + resultado);
        return resultado;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        double resultado = a / b;
        operacionDAO.guardarOperacion("División: " + a + " / " + b + " = " + resultado);
        return resultado;
    }
    
}
