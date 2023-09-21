package Servicio;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import DAO.DaoPersonas;
import DAO.DaoBotes;
import POJO.Persona;
import POJO.Bote;

public class Servicio {

	private static Servicio servicio = null;
	private HashMap<Persona, Persona> personas;
	private HashMap<Bote, Bote> botes;
	private HashMap<Bote, Persona> personaBote;
	
	public Servicio() {
		personas = DaoPersonas.getInstance().getPersonas();
		botes = DaoBotes.getInstance().getBotes();
		personaBote = new HashMap<Bote, Persona>();
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
		/*
        Iterator<Map.Entry<Bote, Persona>> i = personaBote.entrySet().iterator();
		while(i.hasNext()) {
            Map.Entry<Bote, Persona> pb = i.next();
            Bote pk = pb.getKey();
            Persona pv = pb.getValue();
            
            System.out.print(pk.getZona() + "-" + pv.getZona());
		}
		*/
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
	}
	
	
	
	public Servicio getInstance() {
		if(servicio == null) {
			return new Servicio();
		}
		return servicio;
	}
	
	
	
	
}
