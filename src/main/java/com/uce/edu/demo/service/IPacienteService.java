package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

public interface IPacienteService {

	public void insertar(Paciente p);

	public void actualizar(Paciente p);

	public Paciente buscar(Integer id);

	public Paciente buscarPorCedula(String cedula);

	public List<PacienteSencillo> buscarPorFechaGenero(LocalDateTime fechaMinima, String genero);

	public void eliminar(Integer id);

}
