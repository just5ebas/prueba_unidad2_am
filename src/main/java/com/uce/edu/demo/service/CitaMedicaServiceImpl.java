package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepository iCitaMedicaRepository;

	@Override
	public void insertar(CitaMedica cm) {
		this.iCitaMedicaRepository.insertar(cm);
	}

	@Override
	public void actualizar(CitaMedica cm) {
		this.iCitaMedicaRepository.actualizar(cm);
	}

	@Override
	public CitaMedica buscarPorNumeroCita(String numeroCita) {
		return this.iCitaMedicaRepository.buscarPorNumeroCita(numeroCita);
	}

}
