package DAO;

import java.util.Date;
import java.util.Random;
import java.util.TreeMap;

import POJO.Pais;
import POJO.Pasajero;
import POJO.Zona;

public class DaoPersonas {
	
	private static DaoPersonas dao = null;
	private TreeMap<Pasajero, Pasajero> pasajeros = new TreeMap<Pasajero, Pasajero>();
	
	private DaoPersonas(){
		/*
		Pasajero pasajero = new Pasajero("123456789A", Pais.ALEMANIA, Zona.BABOR, "Persona1", false, new Date(2000, 01, 01), 10);
		pasajeros.put(pasajero, pasajero);
		
		pasajero = new Pasajero("123456789B", Pais.FRANCIA, Zona.ESTRIBOR, "Persona2", false, new Date(2001, 01, 01), 9);
		pasajeros.put(pasajero, pasajero);
		
		pasajero = new Pasajero("123456789C", Pais.ESPANA, Zona.POPA, "Persona3", false, new Date(2002, 01, 01), 8);
		pasajeros.put(pasajero, pasajero);
		*/
		
		Pasajero pasajero;
		
		for(int i=0; i<10; i++) {

			pasajero = new Pasajero(generarDNI(), obtenerPaisAleatorio(), obtenerZonaAleatorio(), generarNombreAleatorio(), minusvaliaAleatorio(), fechaAleatoria(), i);
			
			pasajeros.put(pasajero, pasajero);
		}
		
	}
	

	
	private static String generarDNI() {
        Random random = new Random();
        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int numeroDNI = random.nextInt(90000000) + 10000000;
        int indice = numeroDNI % 27;
        char letraControl = letras.charAt(indice); 
        return String.format("%d%c", numeroDNI, letraControl);
    }
	
    private static Pais obtenerPaisAleatorio() {
        Pais[] paises = Pais.values();
        Random random = new Random();
        int indiceAleatorio = random.nextInt(paises.length);
        return paises[indiceAleatorio];
    }
    
    private static Zona obtenerZonaAleatorio() {
        Zona[] zonas = Zona.values();
        Random random = new Random();
        int indiceAleatorio = random.nextInt(zonas.length);
        return zonas[indiceAleatorio];
    }
    
    private static String generarNombreAleatorio() {
        String[] nombres = { "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hannah", "Ian", "Julia" };
        Random random = new Random();
        String nombre = nombres[random.nextInt(nombres.length)];

        return nombre;
    }
    
    private static Boolean minusvaliaAleatorio() {
		Random random = new Random();
		int numAleatorio = random.nextInt(1);
		if(numAleatorio == 0) {
			return false;
		}
		else {
			return true;
		}
    }
	
    private static Date fechaAleatoria() {
        Random random = new Random();
        
        long milisegundosAleatorios = random.nextLong();
        
        long rangoDeAnios = 10;
        long milisegundosEnUnAnio = 365L * 24 * 60 * 60 * 1000;
        long milisegundosEnElPasado = milisegundosAleatorios % (rangoDeAnios * milisegundosEnUnAnio);
        
        long tiempoActual = System.currentTimeMillis();
        long milisegundosFechaAleatoria = tiempoActual - milisegundosEnElPasado;
        
        Date fechaAleatoria = new Date(milisegundosFechaAleatoria);
        
        return fechaAleatoria;
    }
    
    
	public static DaoPersonas getInstance() {
		if(dao == null) {
			return new DaoPersonas();
		}
		return dao;
	}

}
