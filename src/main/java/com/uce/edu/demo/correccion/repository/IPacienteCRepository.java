package com.uce.edu.demo.correccion.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.correccion.repository.modelo.Paciente;
import com.uce.edu.demo.correccion.repository.modelo.PacienteSencillo;

public interface IPacienteCRepository {

	public void insertar(Paciente p);

	public void actualizar(Paciente p);

	public Paciente buscar(Integer id);

	public Paciente buscarPorCedula(String cedula);

	public List<PacienteSencillo> buscarPorFechaGenero(LocalDateTime fecha, String genero);

	public void eliminar(Integer id);

}
