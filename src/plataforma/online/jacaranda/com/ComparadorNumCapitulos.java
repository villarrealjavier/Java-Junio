package plataforma.online.jacaranda.com;

import java.util.Comparator;

public class ComparadorNumCapitulos implements Comparator<Temporada> {

	@Override
	public int compare(Temporada o1, Temporada o2) {
		// TODO Auto-generated method stub
		return o2.getNumeroCapitulos().compareTo(o1.getNumeroCapitulos());
	}

}
