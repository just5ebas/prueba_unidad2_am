package com.uce.edu.demo.coreccion.service;

import com.uce.edu.demo.correccion.repository.modelo.Doctor;

public interface IDoctorCService {

	public void insertar(Doctor d);

	public void actualizar(Doctor d);

	public Doctor buscar(Integer id);

	public Doctor buscarPorCedula(String cedula);

	public void eliminar(Integer id);

}
