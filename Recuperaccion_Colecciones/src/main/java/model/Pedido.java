package main.java.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Pedido {
	private Integer id;
	private String codigo;
	private Status status;
	private Cliente cliente;
	private static Integer secuencia=0;
	
	private List<Linea> listaLineas;
	
	public Pedido() {
		this.id=secuencia++;
		this.listaLineas= new ArrayList<>();
		cliente = new Cliente();
	}
	public Pedido(String codigo,Status status ,Cliente cliente ) {
		this.id=secuencia++;
		this.codigo=codigo;
		this.status=status;
		this.cliente=cliente;
		this.listaLineas= new ArrayList<>();
	}
	
	public void addLinea(Linea linea) {
		listaLineas.add(linea);
		
	}
	public void borrarLinea(Integer id) {
		Iterator<Linea> iterator= listaLineas.iterator();
		if (status!=Status.ENVIADO) {
			while(iterator.hasNext()) {
				Linea l = iterator.next();
				l.getId().equals(id);
				listaLineas.remove(l);
		}
	
		}
	}
	
	public void vaciarPedido() {
		listaLineas.clear();
	}
	public Double getCostePedido() {
		Double resultado=0.0;
		for (Linea l : listaLineas) {
			resultado+= l.getImporte();
		}
		return resultado;
	}
	
	public Integer getNumeroProductos() {
		Integer resultado=0;
		for (Linea l : listaLineas) {
			resultado+= l.getCantidad();
		}
		return resultado;

	}
	
	public List<Linea> mostrarLineasPorIDAscendente() {
		listaLineas.sort(new Comparator<Linea>() {

			@Override
			public int compare(Linea o1, Linea o2) {
				// TODO Auto-generated method stub
				return o1.getId().compareTo(o2.getId());
			}
			
		}
		);
		return listaLineas;
	}
	public List<Linea> mostrarLineasPorPrecioDescendente() {
		listaLineas.sort(new Comparator<Linea>(){

			@Override
			public int compare(Linea o1, Linea o2) {
				// TODO Auto-generated method stub
				return o2.getImporte().compareTo(o1.getImporte());
			}
			
		});
		return listaLineas;
		
	}
	
	public Double getPrecio() {
		Double resultado=0.0;
		for (Linea l: listaLineas) {
			resultado+=l.getImporte();
		}
		
		return resultado;
		
	}
	//NO ES NECESARIO YA QUE SE PUEDE SACAR EL PRODUCTO SIN HACER ESTO
	/*
	public String obtenerProductos() {
		Producto p1= new Producto();
		for (Linea l: listaLineas) {
			p1=l.getProducto();
		}
		return p1.toString();
	}*/
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getcodigo() {
		return codigo;
	}
	public void setcodigo(String codigo) {
		this.codigo = codigo;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Linea> getListaLineas() {
		return listaLineas;
	}
	public void setListaLineas(List<Linea> listaLineas) {
		this.listaLineas = listaLineas;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", codigo=" + codigo + ", status=" + status + ", cliente=" + cliente
				+ ", listaLineas=" + listaLineas + "]";
	}
}
