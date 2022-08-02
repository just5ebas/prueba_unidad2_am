package com.uce.edu.demo.coreccion.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.correccion.repository.IPacienteCRepository;
import com.uce.edu.demo.correccion.repository.modelo.Paciente;
import com.uce.edu.demo.correccion.repository.modelo.PacienteSencillo;

@Service
public class PacienteCServiceImpl implements IPacienteCService {

	@Autowired
	private IPacienteCRepository iPacienteRepository;

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
