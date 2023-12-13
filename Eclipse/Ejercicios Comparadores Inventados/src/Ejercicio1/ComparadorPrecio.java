package Ejercicio1;

import java.util.Comparator;

public class ComparadorPrecio implements Comparator<Zapato>{

	@Override
	public int compare(Zapato z1, Zapato z2) {
		int result = 0;
		if(z1.getPrecio()>z2.getPrecio()) result = 1;
		else if(z1.getPrecio()<z2.getPrecio()) result = -1;
		return result;
	}

}
