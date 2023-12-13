package Ejercicio1;

import java.util.Comparator;

public class Zapato implements Comparable<Zapato>{

	private float precio;
	private Integer numero;
	private TipoColor Color;
	private String marca;
	
	
	public Zapato(float precio, Integer numero, TipoColor color, String marca) {
		super();
		this.precio = precio;
		this.numero = numero;
		Color = color;
		this.marca = marca;
	}
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public TipoColor getColor() {
		return Color;
	}
	public void setColor(TipoColor color) {
		Color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		return "precio= " + precio + ", marca= " + marca;
	}
	

	
	//METODO 1: implementar interfaz 'Comparable<T>' a la clase y usar el siguiente metodo, solo funciona para comparar un atributo
	@Override
	public int compareTo(Zapato zapato) {
		return this.marca.compareTo(zapato.getMarca());
	}
	
	
	
	
	//METODO 2:
	public static Comparator<Zapato> PrecioComparator = new Comparator<Zapato>() {
	    @Override
	    public int compare(Zapato z1, Zapato z2) {
	        return (int) (z1.getPrecio() - z2.getPrecio());
	    }
	};
	
	public static Comparator<Zapato> MarcaComparator = new Comparator<Zapato>() {
		@Override
		public int compare(Zapato z1, Zapato z2) {
			return z1.getMarca().compareTo(z2.getMarca());
		}
	};
	
	
	
	
	//METODO 3:
	public static Comparador getComparador(TipoComparador comparador) {
		return new Comparador(comparador);
	}
	
	
	private static class Comparador implements Comparator<Zapato>{

		private TipoComparador comparador;
		
		public Comparador(TipoComparador comparador) {
			this.comparador = comparador;
		}

		@Override
		public int compare(Zapato z1, Zapato z2) {
			int numero = 0;
			
			switch(comparador) {
			
				case MARCA: numero = z1.getMarca().compareTo(z2.getMarca());
					break;

				case PRECIO: numero = (int) (z1.getPrecio() - z2.getPrecio());
					break;
			
			}
			return numero;
			
			/*
			int result = 0;
			if(z1.getPrecio()>z2.getPrecio()) result = 1;
			else if(z1.getPrecio()<z2.getPrecio()) result = -1;
			return result;
			*/
		}
		
	}
	
	
}
