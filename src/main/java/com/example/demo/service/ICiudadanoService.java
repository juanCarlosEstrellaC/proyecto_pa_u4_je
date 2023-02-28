package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Estudiante;

public interface ICiudadanoService {

	public List<Ciudadano> consultarTodos();
	public Estudiante convertir(Ciudadano ciudadano);
	public List<Estudiante> procesarEstudiante();
	
	public void procesarEstudianteParalelo();

	
}
