package main.java.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Producto {
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private String nombre;
	private Integer id;
	private String descripcion;
	private Double precioUnitario;
	
	public Producto() {
		this.fechaAlta=LocalDate.now();
	}
	
	public Producto(String nombre, Double precioUnitario) {
		this.nombre=nombre;
		this.precioUnitario=precioUnitario;
		
		
	}

	public Producto(String nombre, LocalDate fechaAlta,LocalDate fechaBaja,Double precioUnitario) {
		this.nombre=nombre;
		this.fechaAlta=fechaAlta;
		this.fechaBaja=fechaBaja;
		this.precioUnitario=precioUnitario;
		
		
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public LocalDate getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public boolean isActivo() {

		return this.fechaBaja==null;
	}

	@Override
	public String toString() {
		return "Producto [fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", nombre=" + nombre + ", id=" + id
				+ ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + "]";
	}
	
}
