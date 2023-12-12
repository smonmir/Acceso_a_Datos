package Test;

import POJO.Caja;

public class Test {

	public static void main(String[] args) {
		
		Caja<Integer> caja1 = new Caja();
		
		caja1.pon(5);
		Integer dato1 = caja1.quita();
		caja1.imprimirDato("Hola");
		
		Caja<String> caja2 = new Caja();
		
		caja2.pon("AB");
		String dato2 = caja2.quita();
		caja2.imprimirDato(50);
		
	}

}
