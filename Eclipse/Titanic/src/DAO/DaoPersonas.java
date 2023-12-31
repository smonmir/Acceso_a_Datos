package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import POJO.NivelResponsabilidad;
import POJO.Pais;
import POJO.Pasajero;
import POJO.Persona;
import POJO.TipoPersona;
import POJO.Tripulacion;
import POJO.Zona;

public class DaoPersonas {
	
	private static DaoPersonas dao = null;
	private LinkedHashMap<Persona, Persona> personas;
	private static boolean existeCapitan = false;
	private static ArrayList<String> dniUtilizados = new ArrayList<String>();
	private final Integer NUM_PASAJEROS = 50;
	private final Integer NUM_TRIPULANTES = 50;
	
	private DaoPersonas(){
	
		personas = new LinkedHashMap<Persona, Persona>();
		
		Pasajero pasajero;
		Tripulacion tripulante;
		
		
		for(int i=0; i<NUM_TRIPULANTES; i++) {
			String dni = generarDNI();
			tripulante = new Tripulacion(dni, obtenerPaisAleatorio(), obtenerZonaAleatorio(), generarNombreAleatorio(), minusvaliaAleatorio(), fechaAleatoria(), obtenerTipoPersonaAleatorio(), obtenerNivelResponsabilidadAleatorio());
			personas.put(tripulante, tripulante);	
		}
		
		
		
		for(int j=0; j<NUM_PASAJEROS; j++) {
			pasajero = new Pasajero(generarDNI(), obtenerPaisAleatorio(), obtenerZonaAleatorio(), generarNombreAleatorio(), minusvaliaAleatorio(), fechaAleatoria(), obtenerTipoPersonaAleatorio(), j);
			personas.put(pasajero, pasajero);
		}
	}
	
	
	public LinkedHashMap<Persona, Persona> getPersonas(){
		return personas;
	}
	
	
	private static String generarDNI() {
        Random random = new Random();
        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String cadenaNum = "";
        int aleatorio, letraAleatorio;
        boolean existe;

        do {
        	existe = false;
            for(int i=0; i<8; i++) {
            	aleatorio = random.nextInt(9);
            	cadenaNum += ""+ aleatorio;
            }
            letraAleatorio = random.nextInt(letras.length());
            cadenaNum += letras.charAt(letraAleatorio);
            
            for(int j = 0; j<dniUtilizados.size(); j++) {
            	if(dniUtilizados.get(j).equalsIgnoreCase(cadenaNum)){
            		existe = true;
            		break;
            	}
            }
            if(existe == false) {
                dniUtilizados.add(cadenaNum);
            }
            
        }while(existe == true);
        
        return cadenaNum;
        
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
    
    private static TipoPersona obtenerTipoPersonaAleatorio() {
    	TipoPersona[] tipoPersona = TipoPersona.values();
        Random random = new Random();
        int indiceAleatorio = random.nextInt(tipoPersona.length);
        return tipoPersona[indiceAleatorio];
    }
    
    private static NivelResponsabilidad obtenerNivelResponsabilidadAleatorio() {
    	NivelResponsabilidad[] nivelResponsabilidad = NivelResponsabilidad.values();
        Random random = new Random();
        int indiceAleatorio;
        
        if(existeCapitan != true) {
        	indiceAleatorio = random.nextInt(nivelResponsabilidad.length);
        }
        else {
        	indiceAleatorio = random.nextInt(nivelResponsabilidad.length-1);
        }
        if(indiceAleatorio == nivelResponsabilidad.length-1) {
        	existeCapitan = true;
        }
        return nivelResponsabilidad[indiceAleatorio];
    }
    
    
	public static DaoPersonas getInstance() {
		if(dao == null) {
			return dao = new DaoPersonas();
		}
		return dao;
	}

}
