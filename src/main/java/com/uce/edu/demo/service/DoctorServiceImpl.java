package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.modelo.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepository iDoctorRepository;

	@Override
	public void insertar(Doctor d) {
		this.iDoctorRepository.insertar(d);
	}

	@Override
	public void actualizar(Doctor d) {
		this.iDoctorRepository.actualizar(d);
	}

	@Override
	public Doctor buscar(Integer id) {
		return this.iDoctorRepository.buscar(id);
	}

	@Override
	public Doctor buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iDoctorRepository.buscarPorCedula(cedula);
	}

	@Override
	public void eliminar(Integer id) {
		this.iDoctorRepository.eliminar(id);
	}

}
