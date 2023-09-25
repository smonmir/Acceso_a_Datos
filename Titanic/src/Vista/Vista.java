package Vista;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import POJO.Bote;
import POJO.Persona;

public class Vista {

	
	
	public Vista() {
		
	}
	
	
	public void mostarDatos(HashMap<Bote, HashMap<Persona, Persona>> personaBote) {
		
		//Mostrar BOTE/PERSONA
        Iterator<Map.Entry<Bote, HashMap<Persona, Persona>>> i = personaBote.entrySet().iterator();
		while(i.hasNext()) {
            Map.Entry<Bote, HashMap<Persona, Persona>> pb = i.next();
            Bote bk = pb.getKey();
            HashMap<Persona, Persona> pv = pb.getValue();
            
            System.out.print(bk.getId() + "-" + bk.getZona() + "\n");
            
            for (Map.Entry<Persona, Persona> personaEntry : pv.entrySet()) {
                Persona personaKey = personaEntry.getKey();
                Persona personaValue = personaEntry.getValue();
                
                System.out.print(personaKey.getDni() + "-" + personaKey.getZona() + "\n");
                
            }
            
            System.out.print("\n");
		}
		
	}
	
	
}