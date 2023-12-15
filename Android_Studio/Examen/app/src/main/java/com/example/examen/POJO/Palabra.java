package com.example.examen.POJO;

public class Palabra {

    private int idPalabra;
    private String nombre;
    private boolean aparecido;
    private boolean acertada;


    public Palabra(String nombre, boolean aparecido, boolean acertada) {
        this.nombre = nombre;
        this.aparecido = aparecido;
        this.acertada = acertada;
    }


    public int getIdPalabra() {
        return idPalabra;
    }

    public void setIdPalabra(int idPalabra) {
        this.idPalabra = idPalabra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAparecido() {
        return aparecido;
    }

    public void setAparecido(boolean aparecido) {
        this.aparecido = aparecido;
    }

    public boolean isAcertada() {
        return acertada;
    }

    public void setAcertada(boolean acertada) {
        this.acertada = acertada;
    }
}
