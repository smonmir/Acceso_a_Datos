package Controlador;

import java.util.HashMap;

import POJO.Bote;
import POJO.Persona;
import Servicio.Servicio;
import Vista.Vista;

public class Controlador {
	
	
	private Servicio servicio;
	private Vista vista;
	
	public Controlador() {
		servicio = Servicio.getInstance();
		vista = new Vista();
	}
	
	
	public void iniciar() {
		servicio.asignarPersonasBote();
		vista.mostarDatos(servicio.getPersonasBotes());		
	}
	

}
