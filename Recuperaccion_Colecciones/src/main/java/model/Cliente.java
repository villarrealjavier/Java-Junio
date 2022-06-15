package main.java.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private Integer id;
	private String nombre;
	private String apellidos;
	private String email;
	private String dni;
	private LocalDate fechaNacimiento;
	private Genero genero;
	
	
	public Cliente() {
		
	}
	public Cliente(String nombre, String apellidos, String email,LocalDate fechaNacimiento,Genero genero) {
			this.nombre=nombre;
			this.apellidos=apellidos;
			this.email=email;
			this.fechaNacimiento=fechaNacimiento;
			this.genero=genero;
			
		
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", dni="
				+ dni + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + "]";
	}
}
