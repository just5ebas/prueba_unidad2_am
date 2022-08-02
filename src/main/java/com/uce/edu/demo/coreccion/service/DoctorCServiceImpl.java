package com.uce.edu.demo.coreccion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.correccion.repository.IDoctorCRepository;
import com.uce.edu.demo.correccion.repository.modelo.Doctor;

@Service
public class DoctorCServiceImpl implements IDoctorCService {

	@Autowired
	private IDoctorCRepository iDoctorRepository;

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
