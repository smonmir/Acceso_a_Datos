package Servicio;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import DAO.DaoPersonas;
import DAO.DaoBotes;
import POJO.Persona;
import POJO.Zona;
import POJO.Bote;

public class Servicio {

	private static Servicio servicio = null;
	private HashMap<Persona, Persona> personas;
	private HashMap<Bote, Bote> botes;
	private HashMap<Bote, HashMap<Persona, Persona>> personaBote;
	
	public Servicio() {
		personas = DaoPersonas.getInstance().getPersonas();
		botes = DaoBotes.getInstance().getBotes();
		personaBote = new HashMap<Bote, HashMap<Persona, Persona>>();
	}
	
	
	
	
	public void asignarPersonasBote() {
		
		/*
        Iterator<Map.Entry<Bote, Bote>> iteratorBote = botes.entrySet().iterator();
		while(iteratorBote.hasNext()) {
            Map.Entry<Bote, Bote> boteEntry = iteratorBote.next();
            Bote boteKey = boteEntry.getKey();
            Bote boteValue = boteEntry.getValue();
            
            
            Iterator<Map.Entry<Persona, Persona>> iteratorPersona = personas.entrySet().iterator();
    		while(iteratorPersona.hasNext()) {
                Map.Entry<Persona, Persona> personaEntry = iteratorPersona.next();
                Persona personaKey = personaEntry.getKey();
                Persona personaValue = personaEntry.getValue();
                
                if(boteKey.getZona().equals(personaValue.getZona())){
                	personaBote.put(boteKey, personaValue);
                }
    		}

		}
		*/
		
		//Mostrar PERSONAS
		/*
		int i= 1;
		Iterator<Map.Entry<Persona, Persona>> iteratorPersona = personas.entrySet().iterator();
		while(iteratorPersona.hasNext()) {
            Map.Entry<Persona, Persona> personaEntry = iteratorPersona.next();
            Persona personaKey = personaEntry.getKey();
            Persona personaValue = personaEntry.getValue();
            
            System.out.print(personaKey.getClass() + "-" + personaKey.getDni() + "-" + personaKey.getNombre() + "-" + personaKey.getPais() + "-" + personaKey.getFechaNacimiento() + "-" + personaKey.getTipoPersona() + "-" + personaKey.getZona() + "-" + personaKey.isMinusvalia() 
            + "\n" + personaValue.getClass() + "-" + personaValue.getDni() + "-" + personaValue.getNombre() + "-" + personaValue.getPais() + "-" + personaValue.getFechaNacimiento() + "-" + personaValue.getTipoPersona() + "-" + personaValue.getZona() + "-" + personaValue.isMinusvalia() + "\n");
            i++;
            System.out.println("\n");
		}
		*/
		
		//Mostrar BOTES
		/*
        Iterator<Map.Entry<Bote, Bote>> it = botes.entrySet().iterator();
		while(it.hasNext()) {
            Map.Entry<Bote, Bote> boteEntry = it.next();
            Bote boteKey = boteEntry.getKey();
            Bote boteValue = boteEntry.getValue();
            
            System.out.println(boteKey.getId() + "-" + boteKey.getZona() + "-" + boteKey.getNumPlazas() + 
            		"\n" + boteValue.getId() + "-" + boteValue.getZona() + "-" + boteValue.getNumPlazas());
		}
		*/
		
		
		//Asignacion por cada Zona
		Zona[] zonas = Zona.values();
		
		for(int i = 0; i<zonas.length; i++) {
			
			HashMap<Bote, Bote> zonaBotes = new HashMap<Bote, Bote>();
			HashMap<Persona, Persona> zonaPersonas = new HashMap<Persona, Persona>();
			
            Iterator<Map.Entry<Persona, Persona>> iteratorPersona = personas.entrySet().iterator();
    		while(iteratorPersona.hasNext()) {
                Map.Entry<Persona, Persona> personaEntry = iteratorPersona.next();
                Persona personaKey = personaEntry.getKey();
                Persona personaValue = personaEntry.getValue();
                
	            if(personaKey.getZona() == zonas[i]) {
	            	zonaPersonas.put(personaKey, personaValue);
	            }
    		}
    		
	        Iterator<Map.Entry<Bote, Bote>> iteratorBote = botes.entrySet().iterator();
			while(iteratorBote.hasNext()) {
	            Map.Entry<Bote, Bote> boteEntry = iteratorBote.next();
	            Bote boteKey = boteEntry.getKey();
	            Bote boteValue = boteEntry.getValue();
	            
	            if(boteKey.getZona() == zonas[i]) {
	            	zonaBotes.put(boteKey, boteValue);
	            }
	            
			}
			
	        Iterator<Map.Entry<Bote, Bote>> iterBote = zonaBotes.entrySet().iterator();
			while(iterBote.hasNext()) {
	            Map.Entry<Bote, Bote> boteEntry = iterBote.next();
	            Bote boteKey = boteEntry.getKey();
	            Bote boteValue = boteEntry.getValue();
	            
	            personaBote.put(boteKey, zonaPersonas);
	            
	            /*
	            Iterator<Map.Entry<Persona, Persona>> iterPersona = zonaPersonas.entrySet().iterator();
	    		while(iterPersona.hasNext()) {
	                Map.Entry<Persona, Persona> personaEntry = iterPersona.next();
	                Persona personaKey = personaEntry.getKey();
	                Persona personaValue = personaEntry.getValue();
	                
	    		}
	    		*/
			}
    		
    		
		}
		
		/*
		asignacionBoteProa();
		asignacionBoteEstribor();
		asignacionBoteBabor();
		asignacionBotePopa();
		*/
		
		//Mostrar BOTE/PERSONA
        Iterator<Map.Entry<Bote, HashMap<Persona, Persona>>> i = personaBote.entrySet().iterator();
		while(i.hasNext()) {
            Map.Entry<Bote, HashMap<Persona, Persona>> pb = i.next();
            Bote bk = pb.getKey();
            HashMap<Persona, Persona> pv = pb.getValue();
            
            System.out.print(bk.getId() +"-"+ bk.getZona() + "\n" + pv.get(personas) + "-" + pv.get(personas)+ "\n\n");
            
            Iterator<Map.Entry<Persona, Persona>> j;
		}
		
	}
	

	//TODO
	public void tiempo() {
        Timer timer = new Timer();
        int delay = 0; // Retraso de 1 segundo (en milisegundos)
        int periodo = 1000; // Intervalo de 2 segundos (en milisegundos)

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                
            }
        }, delay, periodo);
	}
	
	
	public Servicio getInstance() {
		if(servicio == null) {
			return new Servicio();
		}
		return servicio;
	}
	
	
	
	
}
