package com.uce.edu.demo.correccion.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.correccion.repository.modelo.CitaMedica;

@Repository
@Transactional
public class CitaMedicaCRepositoryImpl implements ICitaMedicaCRepository {

	private static final Logger LOG = Logger.getLogger(CitaMedicaCRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica cm) {
		this.entityManager.persist(cm);
		LOG.debug("Cita Medica insertada: " + cm);
	}

	@Override
	public void actualizar(CitaMedica cm) {
		this.entityManager.merge(cm);
		LOG.debug("Cita Medica actualizada: " + cm);
	}

	@Override
	public CitaMedica buscarPorNumeroCita(String numeroCita) {
		TypedQuery<CitaMedica> myQuery = this.entityManager
				.createQuery("SELECT cm FROM CitaMedica1 cm WHERE cm.numero = :numero_cita", CitaMedica.class);
		myQuery.setParameter("numero_cita", numeroCita);
		CitaMedica cm = myQuery.getSingleResult();

		LOG.debug("Cita encontrada: " + cm);

		return cm;
	}

}
