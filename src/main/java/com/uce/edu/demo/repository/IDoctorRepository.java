package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Doctor;

public interface IDoctorRepository {

	public void insertar(Doctor d);

	public void actualizar(Doctor d);

	public Doctor buscar(Integer id);

	public Doctor buscarPorCedula(String cedula);

	public void eliminar(Integer id);

}
