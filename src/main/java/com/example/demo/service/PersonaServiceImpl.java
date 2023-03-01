package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Persona;
import com.example.demo.repository.IPersonaRepository;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaRepository iPersonaRepository;
	
	@Override
	public List<Persona> buscarTodos() {
		return this.iPersonaRepository.buscarTodos();
	}

	@Override
	public Persona buscarPorId(Integer id) {
		return this.iPersonaRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Persona persona) {
		this.iPersonaRepository.actualizar(persona);
		
	}

	@Override
	public void guardar(Persona persona) {
		this.iPersonaRepository.guardar(persona);
	}

	@Override
	public void eliminar(Integer id) {
		this.iPersonaRepository.eliminar(id);
	}

}
