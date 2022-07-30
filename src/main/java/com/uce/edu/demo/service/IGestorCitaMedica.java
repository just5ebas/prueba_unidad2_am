package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.PacienteSencillo;

public interface IGestorCitaMedica {

	public void agendarCita(String numeroCita, LocalDateTime fechaCita, Float valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente);

	public void actualizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita);

	public List<PacienteSencillo> consultarPacientes(LocalDateTime fechaMinima, String genero);
}
