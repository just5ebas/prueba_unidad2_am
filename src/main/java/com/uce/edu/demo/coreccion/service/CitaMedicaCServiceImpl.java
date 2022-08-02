package com.uce.edu.demo.coreccion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.correccion.repository.ICitaMedicaCRepository;
import com.uce.edu.demo.correccion.repository.modelo.CitaMedica;

@Service
public class CitaMedicaCServiceImpl implements ICitaMedicaCService {

	@Autowired
	private ICitaMedicaCRepository iCitaMedicaRepository;

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
