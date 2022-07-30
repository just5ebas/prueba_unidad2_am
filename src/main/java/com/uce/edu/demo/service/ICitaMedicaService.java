package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaService {

	public void insertar(CitaMedica cm);

	public void actualizar(CitaMedica cm);

	public CitaMedica buscarPorNumeroCita(String numeroCita);

}
