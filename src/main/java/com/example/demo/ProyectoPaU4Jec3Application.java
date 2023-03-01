package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Persona;
import com.example.demo.service.IPersonaService;

@SpringBootApplication
public class ProyectoPaU4Jec3Application implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoPaU4Jec3Application.class);
	
	@Autowired
	private IPersonaService iPersonaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4Jec3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Persona miPersona = new Persona();
		miPersona.setNombre("Juan");
		miPersona.setApellido("Estrella");
		miPersona.setCedula("123456");
		miPersona.setGenero("M");
		
		LOG.info("Guardado:");
//		this.iPersonaService.guardar(miPersona);
		
		LOG.info("Actualizado + buscar por Id:");
//		Persona personaBuscada = this.iPersonaService.buscarPorId(1);
//		personaBuscada.setApellido("Mayaguez");
//		this.iPersonaService.actualizar(personaBuscada);
		
		LOG.info("Buscar a Todos:");
		List<Persona> lis = this.iPersonaService.buscarTodos();
		lis.stream().forEach(persona -> System.out.println(persona));

		LOG.info("Eliminacion");
//		this.iPersonaService.eliminar(2);
		
		
	}

}
