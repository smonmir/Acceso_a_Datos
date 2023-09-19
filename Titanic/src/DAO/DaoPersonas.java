package DAO;

import java.util.Date;
import java.util.TreeMap;

import POJO.Pais;
import POJO.Pasajero;
import POJO.Zona;

public class DaoPersonas {
	
	private static DaoPersonas dao = null;
	private TreeMap<Pais, TreeMap<String, Pasajero>> pasajeros;
	
	private DaoPersonas() {
		
		
		
		pasajeros.put(Pais.ALEMANIA, new TreeMap<>());
		pasajeros.get(Pais.ALEMANIA).put("Persona1", new Pasajero("123456789", Pais.ALEMANIA, Zona.BABOR, "Persona1", false, new Date(2000, 01, 01), 10));
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static DaoPersonas getInstance() {
		if(dao == null) {
			return new DaoPersonas();
		}
		return dao;
	}

}
