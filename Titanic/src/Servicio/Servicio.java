package Servicio;


import java.util.TreeMap;

import DAO.DaoPersonas;
import POJO.Persona;

public class Servicio {

	
	private TreeMap<Persona, Persona> personas;
	
	public Servicio() {
		personas = DaoPersonas.getInstance().getPersonas();
	}
	
	
	
	
}
