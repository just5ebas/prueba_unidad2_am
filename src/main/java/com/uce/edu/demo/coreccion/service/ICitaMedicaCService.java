package com.uce.edu.demo.coreccion.service;

import com.uce.edu.demo.correccion.repository.modelo.CitaMedica;

public interface ICitaMedicaCService {

	public void insertar(CitaMedica cm);

	public void actualizar(CitaMedica cm);

	public CitaMedica buscarPorNumeroCita(String numeroCita);

}
