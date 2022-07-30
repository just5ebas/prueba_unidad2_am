package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

@Service
public class GestorCitaImpl implements IGestorCitaMedica {

	private static final Logger LOG = Logger.getLogger(GestorCitaImpl.class);

	@Autowired
	private ICitaMedicaService iCitaMedicaService;

	@Autowired
	private IPacienteService iPacienteService;

	@Autowired
	private IDoctorService iDoctorService;;

	@Override
	public void agendarCita(String numeroCita, LocalDateTime fechaCita, Float valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		CitaMedica cm = new CitaMedica();
		cm.setNumeroCita(numeroCita);
		cm.setFechaCita(fechaCita);
		cm.setValorCita(valorCita);
		cm.setLugarCita(lugarCita);

		cm.setDoctor(this.iDoctorService.buscarPorCedula(cedulaDoctor));

		cm.setPaciente(this.iPacienteService.buscarPorCedula(cedulaPaciente));

		this.iCitaMedicaService.insertar(cm);
	}

	@Override
	public void actualizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		CitaMedica cm = this.iCitaMedicaService.buscarPorNumeroCita(numeroCita);

		cm.setDiagnostico(diagnostico);
		cm.setReceta(receta);
		cm.setFechaProximaCita(fechaProximaCita);

		this.iCitaMedicaService.actualizar(cm);
	}

	@Override
	public List<PacienteSencillo> consultarPacientes(LocalDateTime fechaMinima, String genero) {
		List<PacienteSencillo> listaConsulta = this.iPacienteService.buscarPorFechaGenero(fechaMinima, genero);

		listaConsulta.stream().forEach(p -> LOG.info("Paciente encontrado: " + p));

		return listaConsulta;
	}

}
