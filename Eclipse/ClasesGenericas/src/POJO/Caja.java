package POJO;

public class Caja<T> {

	private T dato;

	public Caja() {
		
	}
	
	public T quita() {
		return dato;
	}
	
	public void pon(T dato) {
		this.dato = dato;
	}
	
	
	
	//METODO GENERICO
	
	public <M> void imprimirDato(M dato){
		System.out.println(dato);
	}
	
}
