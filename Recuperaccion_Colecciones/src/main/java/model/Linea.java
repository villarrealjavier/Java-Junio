package main.java.model;

import java.util.List;

public class Linea {
	private Integer id;
	private String codigo;
	private Integer cantidad;
	private Double importe;
	private Producto producto;
	private static Integer secuencia=0;
	
	public Linea() {
		
	}
	public Linea(String codigo, Producto producto, Integer id,Integer cantidad,Double importe) {
		this.codigo=codigo;
		this.id=secuencia++;
		this.cantidad=cantidad;
		this.producto=producto;
		this.importe=this.importe;
		//this.importe=this.cantidad*producto.getPrecioUnitario();

	}
	public Linea(String codigo, Producto producto, Integer id,Integer cantidad) {
		this.codigo=codigo;
		this.id=secuencia++;
		this.cantidad=cantidad;
		this.producto=producto;
		this.importe=this.cantidad*producto.getPrecioUnitario();

	}
	
	public boolean addProducto(Producto p1) {
		boolean resultado=false;
		if (p1.getFechaBaja()==null && this.importe>0) {
			setProducto(p1);
			resultado=true;
		}
		
		return resultado;
	}
	
	public boolean eliminarProducto(Integer id) {
		boolean resultado=false;
		if (this.producto.equals(id)) {
			producto=null;
			resultado=true;
		}
		return resultado;
	}
	
	public boolean VaciarLinea() {
		boolean resultado=false;
		this.producto=null;
		this.cantidad=null;
		this.codigo=null;
		this.importe=null;
		resultado=true;
		
		return resultado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "Linea [id=" + id + ", codigo=" + codigo + ", cantidad=" + cantidad + ", importe=" + importe
				+ ", producto=" + producto + "]";
	}
	
	
}
