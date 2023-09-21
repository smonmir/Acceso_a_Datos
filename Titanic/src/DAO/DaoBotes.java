package DAO;

import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

import POJO.Bote;
import POJO.Zona;

public class DaoBotes {

	private static DaoBotes dao = null;
	private HashMap<Bote, Bote> botes;
	
	private DaoBotes() {
		
		botes = new HashMap<Bote, Bote>();
		
		Bote bote;
		
		for(int i=0; i<10; i++) {
			bote = new Bote(numPlazasAleatorio(), obtenerZonaAleatorio());
			botes.put(bote, bote);
		}
		
	}
	
	public HashMap<Bote, Bote> getBotes(){
		return botes;
	}
	
	
	private Integer numPlazasAleatorio() {
		Random random = new Random();
		Integer numAle = random.nextInt(10);
		return numAle;
	}
	
	
    private Zona obtenerZonaAleatorio() {
        Zona[] zonas = Zona.values();
        Random random = new Random();
        int indiceAleatorio = random.nextInt(zonas.length);
        return zonas[indiceAleatorio];
    }
	
	public static DaoBotes getInstance() {
		if(dao==null) {
			return new DaoBotes();
		}
		return dao;
	}
	
}
