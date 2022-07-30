package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaRepository {

	public void insertar(CitaMedica cm);

	public void actualizar(CitaMedica cm);

	public CitaMedica buscarPorNumeroCita(String numeroCita);

}
