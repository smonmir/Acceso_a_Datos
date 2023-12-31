package POJO;

import java.util.Date;
import java.util.Objects;

public class Pasajero extends Persona implements Comparable<Persona>{


	private Integer numHabitacion;
	
	
	public Pasajero(String dni, Pais pais, Zona zona, String nombre, boolean minusvalia, Date fechaNacimiento, TipoPersona tipoPersona, Integer numHabitacion) {
		super(dni, pais, zona, nombre, minusvalia, fechaNacimiento, tipoPersona);
		this.numHabitacion = numHabitacion;
	}


	public Integer getNumHabitacion() {
		return numHabitacion;
	}


	public void setNumHabitacion(Integer numHabitacion) {
		this.numHabitacion = numHabitacion;
	}


	@Override
	public int hashCode() {
		return Objects.hash(super.getDni(), super.getFechaNacimiento(), super.isMinusvalia(), super.getNombre(), super.getPais(), numHabitacion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		return super.getDni().equals(other.getDni()) && super.getFechaNacimiento().equals(other.getFechaNacimiento()) && 
				super.isMinusvalia() == other.isMinusvalia() && super.getNombre().equals(other.getNombre()) && super.getPais().equals(other.getPais()) && numHabitacion.equals(other.getNumHabitacion());
	}
	
	


	@Override
	public String toString() {
		return "Pasajero [numHabitacion=" + numHabitacion + ", getDni()=" + getDni() + ", getPais()=" + getPais()
				+ ", getZona()=" + getZona() + ", getNombre()=" + getNombre() + ", isMinusvalia()=" + isMinusvalia()
				+ ", getFechaNacimiento()=" + getFechaNacimiento() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}

	@Override
	public int compareTo(Persona p) {
		int i = p.getPais().compareTo(this.getPais());
		if(i==0) {
			i = p.getNombre().compareTo(this.getNombre());
		}
		return i;
	}
	
	

}
