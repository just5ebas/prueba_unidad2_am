package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteRepository iPacienteRepository;

	@Override
	public void insertar(Paciente p) {
		this.iPacienteRepository.insertar(p);
	}

	@Override
	public void actualizar(Paciente p) {
		this.iPacienteRepository.actualizar(p);
	}

	@Override
	public Paciente buscar(Integer id) {
		return this.iPacienteRepository.buscar(id);
	}

	@Override
	public Paciente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iPacienteRepository.buscarPorCedula(cedula);
	}

	@Override
	public List<PacienteSencillo> buscarPorFechaGenero(LocalDateTime fechaMinima, String genero) {
		// TODO Auto-generated method stub
		return this.iPacienteRepository.buscarPorFechaGenero(fechaMinima, genero);
	}

	@Override
	public void eliminar(Integer id) {
		this.iPacienteRepository.eliminar(id);
	}
}
