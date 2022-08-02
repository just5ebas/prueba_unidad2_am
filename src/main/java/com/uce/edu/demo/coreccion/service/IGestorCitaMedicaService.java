package com.uce.edu.demo.coreccion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.correccion.repository.modelo.PacienteSencillo;

public interface IGestorCitaMedicaService {

	public void generarCita(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente);

	public void actualizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita);

	public List<PacienteSencillo> consultarPacientes(LocalDateTime fecha, String genero);
}
