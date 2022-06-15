package main.java.model;

import java.util.Comparator;

public class ComparadorPorID implements Comparator<Pedido> {

	@Override
	public int compare(Pedido o1, Pedido o2) {
		// TODO Auto-generated method stub
		return o1.getId().compareTo(o2.getId());
	}

}
