package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private List<Producto> lista;
	public Catalogo() {
		lista = new ArrayList<Producto>();
	}
	
	public String mostrarProductos() {
		return lista.toString();
	}
	
	public String mostrarProductosActivos() {
		List<String> lista2 = new ArrayList<>();
		for (Producto p: lista) {
			if(p.getFechaBaja()==null) {
				lista2.add(p.getNombre());
			}
		}
		return lista2.toString();
	}
}
