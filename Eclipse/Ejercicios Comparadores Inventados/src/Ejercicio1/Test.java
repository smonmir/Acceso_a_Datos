package Ejercicio1;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {

		ArrayList<Zapato> zapatos = new ArrayList<Zapato>();
		
		zapatos.add(new Zapato(20F, 39, TipoColor.ROJO, "A"));
		zapatos.add(new Zapato(60F, 41, TipoColor.VERDE, "C"));
		zapatos.add(new Zapato(40F, 43, TipoColor.AZUL, "D"));
		zapatos.add(new Zapato(10F, 45, TipoColor.AZUL, "B"));
		
		//Collections.sort(zapatos);
		
		//Collections.sort(zapatos, Zapato.PrecioComparator);
		
		Collections.sort(zapatos, Zapato.getComparador(TipoComparador.MARCA));
		
		System.out.println(zapatos);
	}

}
