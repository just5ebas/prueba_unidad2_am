package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	private static final Logger LOG = Logger.getLogger(PacienteRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente p) {
		this.entityManager.persist(p);
		LOG.debug("Se inserto al paciente: " + p);
	}

	@Override
	public void actualizar(Paciente p) {
		this.entityManager.merge(p);
		LOG.debug("Se actualizo al paciente: " + p);
	}

	@Override
	public Paciente buscar(Integer id) {
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public Paciente buscarPorCedula(String cedula) {
		LOG.debug("Buscando paciente de cedula: " + cedula);

		TypedQuery<Paciente> myQuery = this.entityManager
				.createQuery("SELECT p FROM Paciente p WHERE p.cedula = :cedula", Paciente.class);
		myQuery.setParameter("cedula", cedula);

		Paciente p = myQuery.getSingleResult();

		LOG.debug("Paciente encontrado: " + p);

		return p;
	}

	@Override
	public List<PacienteSencillo> buscarPorFechaGenero(LocalDateTime fechaMinima, String genero) {
		TypedQuery<PacienteSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PacienteSencillo(p.cedula, p.nombre, p.apellido, p.fechaNacimiento, p.genero) FROM Paciente p WHERE p.fechaNacimiento > :dato_fecha and p.genero = :dato_genero",
				PacienteSencillo.class);
		myQuery.setParameter("dato_fecha", fechaMinima);
		myQuery.setParameter("dato_genero", genero);

		List<PacienteSencillo> lista = myQuery.getResultList();

		LOG.debug("Número de pacientes en la lista: " + lista.size());

		return lista;
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

}
