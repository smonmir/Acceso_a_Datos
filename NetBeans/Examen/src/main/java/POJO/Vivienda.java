/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author dam
 */
public class Vivienda {
    
    private int codigo;
    private int piso;
    private String letra;
    private String propietario;
    private int tarifa;
    private int codigoComunidad;
    private boolean moroso;

    public Vivienda(int piso, String letra, String propietario, int tarifa, int codigoComunidad, boolean moroso) {
        this.piso = piso;
        this.letra = letra;
        this.propietario = propietario;
        this.tarifa = tarifa;
        this.codigoComunidad = codigoComunidad;
        this.moroso = moroso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public int getCodigoComunidad() {
        return codigoComunidad;
    }

    public void setCodigoComunidad(int codigoComunidad) {
        this.codigoComunidad = codigoComunidad;
    }

    public boolean isMoroso() {
        return moroso;
    }

    public void setMoroso(boolean moroso) {
        this.moroso = moroso;
    }

    
    

    
    
    
}
