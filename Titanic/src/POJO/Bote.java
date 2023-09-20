package POJO;

import java.util.Comparator;
import java.util.Objects;

public class Bote implements Comparator<Bote>{

	private static Integer num = 1; 
	private Integer id;
	private Integer numPlazas;
	private Zona zona;
	
	
	public Bote(Integer id, Integer numPlazas, Zona zona) {
		super();
		this.id = num++;
		this.numPlazas = numPlazas;
		this.zona = zona;
	}

	
	public static Integer getNum() {
		return num;
	}

	public static void setNum(Integer num) {
		Bote.num = num;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(Integer numPlazas) {
		this.numPlazas = numPlazas;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id, numPlazas, zona);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bote other = (Bote) obj;
		return Objects.equals(id, other.id) && Objects.equals(numPlazas, other.numPlazas) && zona == other.zona;
	}

	@Override
	public String toString() {
		return "Bote [id=" + id + ", numPlazas=" + numPlazas + ", zona=" + zona + "]";
	}


	@Override
	public int compare(Bote b1, Bote b2) {
		return b1.getId().compareTo(b2.getId());
	}
	
	
	
	
	
	
}
