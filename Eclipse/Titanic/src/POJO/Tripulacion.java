package POJO;

import java.util.Date;
import java.util.Objects;

public class Tripulacion extends Persona implements Comparable<Persona>{
	

	private NivelResponsabilidad nivelResponsabilidad;
	
	public Tripulacion(String dni, Pais pais, Zona zona, String nombre, boolean minusvalia, Date fechaNacimiento, TipoPersona tipoPersona, NivelResponsabilidad nivelResponsabilidad) {
		super(dni, pais, zona, nombre, minusvalia, fechaNacimiento, tipoPersona);
		this.nivelResponsabilidad = nivelResponsabilidad;
	}
	
	public Tripulacion(String dni, Pais pais) {
		super(dni, pais);
		this.nivelResponsabilidad = nivelResponsabilidad;
	}
	

	public NivelResponsabilidad getNivelResponsabilidad() {
		return nivelResponsabilidad;
	}

	public void setNivelResponsabilidad(NivelResponsabilidad nivelResponsabilidad) {
		this.nivelResponsabilidad = nivelResponsabilidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nivelResponsabilidad);
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
		Tripulacion other = (Tripulacion) obj;
		return nivelResponsabilidad == other.nivelResponsabilidad;
	}

	@Override
	public String toString() {
		return "Tripulacion [nivelResponsabilidad=" + nivelResponsabilidad + ", getDni()=" + getDni() + ", getPais()="
				+ getPais() + ", getZona()=" + getZona() + ", getNombre()=" + getNombre() + ", isMinusvalia()="
				+ isMinusvalia() + ", getFechaNacimiento()=" + getFechaNacimiento() + ", toString()=" + super.toString()
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
