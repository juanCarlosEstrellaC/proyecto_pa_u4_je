package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Ciudadano> consultarTodos() {
		Query query = this.entityManager.createNativeQuery("SELECT * FROM ciudadano_p", Ciudadano.class);
		return (List<Ciudadano>) query.getResultList();
	}

}
