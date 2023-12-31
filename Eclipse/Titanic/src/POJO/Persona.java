package POJO;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Persona implements Comparable<Persona>{

	private String dni;
	private Pais pais;
	private Zona zona;
	private String nombre;
	private boolean minusvalia;
	private Date fechaNacimiento;
	private TipoPersona tipoPersona;
	
	public Persona(String dni, Pais pais, POJO.Zona zona, String nombre, boolean minusvalia, Date fechaNacimiento, TipoPersona tipoPersona) {
		super();
		this.dni = dni;
		this.pais = pais;
		this.zona = zona;
		this.nombre = nombre;
		this.minusvalia = minusvalia;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoPersona = tipoPersona;
	}
	
	public Persona(String dni, Pais pais) {
		this.dni = dni;
		this.pais = pais;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isMinusvalia() {
		return minusvalia;
	}

	public void setMinusvalia(boolean minusvalia) {
		this.minusvalia = minusvalia;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(dni, fechaNacimiento, minusvalia, nombre, pais, tipoPersona, zona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& minusvalia == other.minusvalia && Objects.equals(nombre, other.nombre) && pais == other.pais
				&& tipoPersona == other.tipoPersona && zona == other.zona;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", pais=" + pais + ", zona=" + zona + ", nombre=" + nombre + ", minusvalia="
				+ minusvalia + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	@Override
	public int compareTo(Persona p1) {
		int i = this.getPais().compareTo(p1.getPais());
		if(i==0) {
			i = this.getNombre().compareTo(p1.getNombre());
		}
		return i;
	}
	




	
	
	
}
