package com.uce.edu.demo.coreccion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.correccion.repository.ICitaMedicaCRepository;
import com.uce.edu.demo.correccion.repository.modelo.CitaMedica;
import com.uce.edu.demo.correccion.repository.modelo.PacienteSencillo;

@Service
public class GestorCitaMedicaServiceImpl implements IGestorCitaMedicaService {

	private static final Logger LOG = Logger.getLogger(GestorCitaMedicaServiceImpl.class);

	@Autowired
	private ICitaMedicaCRepository iCitaMedicaRepository;

	@Autowired
	private IPacienteCService iPacienteService;

	@Autowired
	private IDoctorCService iDoctorService;

	@Override
	public void generarCita(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		CitaMedica cm = new CitaMedica();
		cm.setNumero(numeroCita);
		cm.setFechaCita(fechaCita);
		cm.setValor(valorCita);
		cm.setLugar(lugarCita);

		cm.setDoctor(this.iDoctorService.buscarPorCedula(cedulaDoctor));

		cm.setPaciente(this.iPacienteService.buscarPorCedula(cedulaPaciente));

		this.iCitaMedicaRepository.insertar(cm);
	}

	@Override
	public void actualizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		CitaMedica cm = this.iCitaMedicaRepository.buscarPorNumeroCita(numeroCita);

		cm.setDiagnostico(diagnostico);
		cm.setReceta(receta);
		cm.setFechaProximaCita(fechaProximaCita);

		this.iCitaMedicaRepository.actualizar(cm);
	}

	@Override
	public List<PacienteSencillo> consultarPacientes(LocalDateTime fecha, String genero) {
//		List<PacienteSencillo> listaConsulta = this.iPacienteService.buscarPorFechaGenero(fecha, genero);
//
//		listaConsulta.stream().forEach(p -> LOG.info("Paciente encontrado: " + p));
//
//		return listaConsulta;
		return null;
	}

}
