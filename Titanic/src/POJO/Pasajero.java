package POJO;

import java.util.Date;
import java.util.Objects;

public class Pasajero extends Persona{


	private Integer numHabitacion;
	
	
	public Pasajero(String dni, Pais pais, Zona zona, String nombre, boolean minusvalia, Date fechaNacimiento, Integer numHabitacion) {
		super(dni, pais, zona, nombre, minusvalia, fechaNacimiento);
		this.numHabitacion = numHabitacion;
	}

	public Pasajero(String dni, Pais pais) {
		super(dni, pais);
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numHabitacion);
		return result;
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
		return Objects.equals(numHabitacion, other.numHabitacion);
	}


	@Override
	public String toString() {
		return "Pasajero [numHabitacion=" + numHabitacion + ", getDni()=" + getDni() + ", getPais()=" + getPais()
				+ ", getZona()=" + getZona() + ", getNombre()=" + getNombre() + ", isMinusvalia()=" + isMinusvalia()
				+ ", getFechaNacimiento()=" + getFechaNacimiento() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}
	
	
	
	

}
