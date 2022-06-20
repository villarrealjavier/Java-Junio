package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private List<Producto> listaCatalogo;
	public Catalogo() {
		listaCatalogo = new ArrayList<Producto>();
	}
	
	public String mostrarProductos() {
		return listaCatalogo.toString();
	}
	
	public String mostrarProductosActivos() {
		StringBuilder sb = new StringBuilder();

		for (Producto p: listaCatalogo) {
			if(p.getFechaBaja()==null) {
				sb.append("Nombre del producto: "+ p.getNombre()+"\n");
			
			}
		}
		return sb.toString();
	}
}
