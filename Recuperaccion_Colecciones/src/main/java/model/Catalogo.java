package main.java.model;

import java.util.HashSet;
import java.util.Set;

public class Catalogo {
	private Set<Producto> conjuntoProductos;
	public Catalogo() {
		conjuntoProductos = new HashSet<Producto>();
	}
	
	public String mostrarProductos() {
		return conjuntoProductos.toString();
	}
	
	public String mostrarProductosActivos() {
		StringBuilder sb = new StringBuilder();

		for (Producto p: conjuntoProductos) {
			if(p.getFechaBaja()==null) {
				sb.append("Nombre del producto: "+ p.getNombre()+"\n");
			
			}
		}
		return sb.toString();
	}
}
