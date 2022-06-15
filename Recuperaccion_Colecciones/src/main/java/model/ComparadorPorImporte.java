package main.java.model;

import java.util.Comparator;

public class ComparadorPorImporte implements Comparator<Pedido> {

	@Override
	public int compare(Pedido o1, Pedido o2) {
		// TODO Auto-generated method stub
		return o1.getCostePedido().compareTo(o2.getCostePedido());
	}

}
