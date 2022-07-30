package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Doctor;

@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository {

	private static final Logger LOG = Logger.getLogger(DoctorRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Doctor d) {
		this.entityManager.persist(d);
		LOG.debug("Se inserto al doctor: " + d);
	}

	@Override
	public void actualizar(Doctor d) {
		this.entityManager.merge(d);
		LOG.debug("Se actualizo al doctor: " + d);
	}

	@Override
	public Doctor buscar(Integer id) {
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public Doctor buscarPorCedula(String cedula) {
		LOG.debug("Buscando doctor de cedula: " + cedula);

		TypedQuery<Doctor> myQuery = this.entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cedula = :cedula",
				Doctor.class);
		myQuery.setParameter("cedula", cedula);

		Doctor d = myQuery.getSingleResult();

		LOG.debug("Doctor encontrado: " + d);

		return d;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

}
