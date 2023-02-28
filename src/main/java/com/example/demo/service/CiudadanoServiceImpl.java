package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.ICiudadanoRepository;
import com.example.demo.repository.IEstudianteRepository;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepository iCiudadanoRepository;

	@Autowired
	private IEstudianteRepository iEstudianteRepository;

	@Override
	public List<Ciudadano> consultarTodos() {
		return this.iCiudadanoRepository.consultarTodos();
	}

	@Override
	public Estudiante convertir(Ciudadano ciudadano) {
		Estudiante estu = new Estudiante();
		estu.setNombreCompleto(ciudadano.getNombre() + ciudadano.getApellido());
		Integer ed = LocalDateTime.now().getYear() - ciudadano.getFechaNacimiento().getYear();
		estu.setEdad(ed);

		this.iEstudianteRepository.insertar(estu);
		return estu;
	}

	@Override
	public List<Estudiante> procesarEstudiante() {
		long tiempoInicial = System.currentTimeMillis();
		List<Ciudadano> lis = consultarTodos();
		List<Estudiante> lisEs = new ArrayList<>();

		Estudiante e = null;
		for (Ciudadano ciudadano : lis) {
			e = convertir(ciudadano);
			lisEs.add(e);
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Tiempo transcurrido en segundos: " + tiempoTranscurrido);

		return lisEs;
	}

	@Override
	public void procesarEstudianteParalelo() {
		long tiempoInicial = System.currentTimeMillis();
		List<Ciudadano> lis = consultarTodos();

		List<Estudiante> listaEstu = lis.parallelStream().map(ciud -> convertir(ciud)).collect(Collectors.toList());
		System.out.println(listaEstu + "hilo " + Thread.currentThread().getName());

		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Tiempo transcurrido en segundos: " + tiempoTranscurrido);

	}

}
