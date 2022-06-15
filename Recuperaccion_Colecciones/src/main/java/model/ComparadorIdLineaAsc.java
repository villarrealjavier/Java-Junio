package main.java.model;

import java.util.Comparator;

public class ComparadorIdLineaAsc implements Comparator<Linea> {

	@Override
	public int compare(Linea o1, Linea o2) {
		// TODO Auto-generated method stub
		return o1.getId().compareTo(o2.getId());
	}

}
