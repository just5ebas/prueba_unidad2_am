package com.uce.edu.demo.coreccion.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.correccion.repository.modelo.Doctor;

@SpringBootTest
@Transactional
@Rollback(true)
class CorreccionImplTest {

	@Autowired
	private IDoctorCService iDoctorCService;

	@Test
	void testCrearDoctor() {
		Doctor d1 = new Doctor();
		d1.setCedula("1236977");
		d1.setNombre("Dennis");
		d1.setApellido("Tapia");
		d1.setFechaNacimiento(LocalDateTime.of(1996, Month.APRIL, 16, 12, 0));
		d1.setNumeroConsultorio("1a");
		d1.setCodigoSenescyt("asd1");
		d1.setGenero("M");
		this.iDoctorCService.insertar(d1);
		assertThat(this.iDoctorCService.buscarPorCedula(d1.getCedula()).getId()).isNotNull();

	}

	@Test
	void testBuscaDoctorPorId() {
		assertThat(this.iDoctorCService.buscar(1).getApellido()).isNotNull();

	}

	@Test
	void testBuscaDoctorPorCedula() {
		Doctor doctor = new Doctor();
		doctor.setCedula("1236922277");
		doctor.setNombre("Dennis");
		doctor.setApellido("Tapia");
		doctor.setFechaNacimiento(LocalDateTime.of(1996, Month.APRIL, 16, 12, 0));
		doctor.setNumeroConsultorio("1a");
		doctor.setCodigoSenescyt("asd1");
		doctor.setGenero("M");
		this.iDoctorCService.insertar(doctor);
		Doctor doctorBuscado = this.iDoctorCService.buscarPorCedula(doctor.getCedula());
		assertEquals(doctor, doctorBuscado);
	}

	@Test
	void testActualizarDoctor() {
		Doctor doctor = new Doctor();
		doctor.setCedula("1231549526");
		doctor.setNombre("Dennis");
		doctor.setApellido("Tapia");
		doctor.setFechaNacimiento(LocalDateTime.of(1996, Month.APRIL, 16, 12, 0));
		doctor.setNumeroConsultorio("1a");
		doctor.setCodigoSenescyt("asd455");
		doctor.setGenero("M");

		this.iDoctorCService.insertar(doctor);
		Doctor doctorBuscado = this.iDoctorCService.buscarPorCedula(doctor.getCedula());
		doctorBuscado.setCodigoSenescyt("121212asad");
		this.iDoctorCService.actualizar(doctorBuscado);
		assertEquals(doctor.getCodigoSenescyt(), doctorBuscado.getCodigoSenescyt());

	}

	@Test
	void testEliminarDoctor() {
		Doctor doctorBuscado = this.iDoctorCService.buscarPorCedula("1231549526");
		assertThat(doctorBuscado.getId()).isNotIn(this.iDoctorCService.buscar(1));
	}
}
