package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IGestorCitaMedica;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(PruebaUnidad2AmApplication.class);

	@Autowired
	private IDoctorService iDoctorService;

	@Autowired
	private IPacienteService iPacienteService;

	@Autowired
	private IGestorCitaMedica iGestorCitaMedica;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Doctor d1 = new Doctor();
		d1.setCedula("1231549526");
		d1.setNombre("Juan");
		d1.setApellido("Taipe");
		d1.setFechaNacimiento(LocalDateTime.of(1980, 9, 9, 10, 1));
		d1.setNumeroConsultorio("325");
		d1.setCodigoSenescyt("PDK-225");
		d1.setGenero("M");

		Doctor d2 = new Doctor();
		d2.setCedula("1895236548");
		d2.setNombre("Angelica");
		d2.setApellido("Toronto");
		d2.setFechaNacimiento(LocalDateTime.of(1976, 4, 30, 19, 48));
		d2.setNumeroConsultorio("501");
		d2.setCodigoSenescyt("PPP-555");
		d2.setGenero("F");

		Paciente p1 = new Paciente();
		p1.setCedula("1346798255");
		p1.setNombre("Jhon");
		p1.setApellido("Escala");
		p1.setFechaNacimiento(LocalDateTime.of(1996, 10, 2, 2, 22));
		p1.setCodigoSeguro("PA005");
		p1.setEstatura(1.76f);
		p1.setPeso(91.2f);
		p1.setGenero("M");

		Paciente p2 = new Paciente();
		p2.setCedula("1715623498");
		p2.setNombre("Carlos");
		p2.setApellido("Vera");
		p2.setFechaNacimiento(LocalDateTime.of(2000, 7, 7, 7, 7));
		p2.setCodigoSeguro("PA006");
		p2.setEstatura(2.01f);
		p2.setPeso(88.88f);
		p2.setGenero("M");

		// 1. INSERTAR DOS DOCTORES
		this.iDoctorService.insertar(d1);
		this.iDoctorService.insertar(d2);

		// 2. INSERTAR DOS PACIENTES
		this.iPacienteService.insertar(p1);
		this.iPacienteService.insertar(p2);

		// 3. CREACION DE CITA MEDICA
		this.iGestorCitaMedica.agendarCita("003", LocalDateTime.of(2022, 7, 30, 11, 0), 5.5f, "Centro de Salud SJM",
				d2.getCedula(), p1.getCedula());

		// 4. ACTUALIZAR CITA MEDICA
		this.iGestorCitaMedica.actualizarCita("003", "Alergia", "Pastilla generica",
				LocalDateTime.of(2022, 8, 15, 11, 15));

		// 5. REGISTRO DE PACIENTES
		this.iGestorCitaMedica.consultarPacientes(LocalDateTime.of(1995, 1, 1, 1, 0), "M");

	}

}
