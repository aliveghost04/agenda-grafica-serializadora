package edu.itla.agenda.modelotabla;

import java.io.Serializable;

public class Contacto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idContacto;
	private String nombre;
	private String apellido;
	private String telefono;
	
	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public Contacto(int idContacto, String nombre, String apellido, String telefono) {
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	} 
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getTelefono() {
		return telefono;
	}
}
