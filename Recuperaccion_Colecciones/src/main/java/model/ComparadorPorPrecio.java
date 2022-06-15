package main.java.model;

import java.util.Comparator;

public class ComparadorPorPrecio implements Comparator<Pedido> {

	@Override
	public int compare(Pedido o1, Pedido o2) {

		return o2.getPrecio().compareTo(o1.getPrecio());
	}

}
