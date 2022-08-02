package com.uce.edu.demo.correccion.repository;

import com.uce.edu.demo.correccion.repository.modelo.CitaMedica;

public interface ICitaMedicaCRepository {

	public void insertar(CitaMedica cm);

	public void actualizar(CitaMedica cm);

	public CitaMedica buscarPorNumeroCita(String numeroCita);

}
