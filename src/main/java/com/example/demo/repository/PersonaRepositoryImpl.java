package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonaRepositoryImpl implements IPersonaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Persona> buscarTodos() {
		Query query = this.entityManager.
				createQuery("SELECT p "
				          + "FROM Persona p");
	
		return query.getResultList();
	}

	@Override
	public Persona buscarPorId(Integer id) {
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void actualizar(Persona persona) {
//		Query query = this.entityManager.
//				createQuery("UPDATE Persona p "
//						  + "SET p.nombre =:datoNombre, p.apellido =:datoApellido, p.cedula =:datoCedula, p.genero =:datoGenero "
//						  + "WHERE p.id =:datoId");
//		query.setParameter("datoNombre", persona.getNombre());
//		query.setParameter("datoApellido", persona.getApellido());
//		query.setParameter("datoCedula", persona.getCedula());
//		query.setParameter("datoGenero", persona.getGenero());
//		query.setParameter("datoId", persona.getId());
//		
//		
//		query.executeUpdate();
		this.entityManager.merge(persona);		
	}

	@Override
	public void guardar(Persona persona) {
		this.entityManager.persist(persona);
	}

	@Override
	public void eliminar(Integer id) {
		Persona p = this.buscarPorId(id);
		this.entityManager.remove(p);	
	}

}
