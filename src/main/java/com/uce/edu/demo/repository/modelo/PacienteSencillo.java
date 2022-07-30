package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;

public class PacienteSencillo {

	private String cedula;
	private String nombre;
	private String apellido;
	private LocalDateTime fechaNacimiento;
	private String genero;

	public PacienteSencillo(String cedula, String nombre, String apellido, LocalDateTime fechaNacimiento,
			String genero) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Cedula: " + cedula + ", Nombre: " + nombre + " " + apellido + ", Fecha de Nacimiento: "
				+ fechaNacimiento + ", Genero: " + genero;
	}

	// GET & SET
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
