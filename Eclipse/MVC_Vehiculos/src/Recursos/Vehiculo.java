package Recursos;



public class Vehiculo {


private String marca;

private String modelo;

private String matricula;

private int usuarioid;

public Vehiculo() {
	

}

public Vehiculo(String marca, String modelo, String matricula, int idUsuario) {
	
	this.marca = marca;
	this.modelo = modelo;
	this.matricula = matricula;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public String getMatricula() {
	return matricula;
}

public void setMatricula(String matricula) {
	this.matricula = matricula;
}

public int getUsuarioid() {
	return usuarioid;
}

public void setUsuarioid(int idUsuario) {
	this.usuarioid = idUsuario;
}


@Override
public String toString() {
	return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + "]";
}






}