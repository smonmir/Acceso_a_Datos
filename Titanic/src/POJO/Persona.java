package POJO;

import java.util.Date;
import java.util.Objects;

public class Persona {

	private String dni;
	private Pais pais;
	private Zona zona;
	private String nombre;
	private boolean minusvalia;
	private Date fechaNacimiento;
	
	public Persona(String dni, Pais pais, POJO.Zona zona, String nombre, boolean minusvalia, Date fechaNacimiento) {
		super();
		this.dni = dni;
		this.pais = pais;
		this.zona = zona;
		this.nombre = nombre;
		this.minusvalia = minusvalia;
		this.fechaNacimiento = fechaNacimiento;
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

	@Override
	public int hashCode() {
		return Objects.hash(dni, fechaNacimiento, minusvalia, nombre, pais, zona);
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
				&& minusvalia == other.minusvalia && Objects.equals(nombre, other.nombre)
				&& Objects.equals(pais, other.pais) && zona == other.zona;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", pais=" + pais + ", zona=" + zona + ", nombre=" + nombre + ", minusvalia="
				+ minusvalia + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
	
	
	
	
}
