package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Persona;

public interface IPersonaService {
	
	public List<Persona> buscarTodos();
	public Persona buscarPorId(Integer id);
	public void actualizar(Persona persona);
	public void guardar(Persona persona);
	public void eliminar(Integer id);
	
}
