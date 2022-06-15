package plataforma.online.jacaranda.com;

import java.util.Comparator;

public class ComparadorPorAnno implements Comparator<Serie> {

	@Override
	public int compare(Serie o1, Serie o2) {
		// TODO Auto-generated method stub
		return o2.getAnno().compareTo(o1.getAnno());
	}

}
