package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Estudiante;
import com.example.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoPaU4JecApplication implements CommandLineRunner {

	
	@Autowired
	private ICiudadanoService iCiudadanoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4JecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Ciudadano> lista = this.iCiudadanoService.consultarTodos();
		for (Ciudadano ciudadano : lista) {
			System.out.println(ciudadano);
		}
		 
		System.out.println();
		Estudiante e = this.iCiudadanoService.convertir(lista.get(0));
		System.out.println(e);
		
		this.iCiudadanoService.procesarEstudianteParalelo();
		
		
	}


	
}
