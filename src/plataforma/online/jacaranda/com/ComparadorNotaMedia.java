package plataforma.online.jacaranda.com;

import java.util.Comparator;

public class ComparadorNotaMedia implements Comparator<Temporada> {

	@Override
	public int compare(Temporada o1, Temporada o2) {
		// TODO Auto-generated method stub
		return o2.getNotaMedia().compareTo(o1.getNotaMedia());
	}

}
