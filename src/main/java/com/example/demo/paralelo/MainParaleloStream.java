package com.example.demo.paralelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainParaleloStream {

	public static void main(String[] args) {

		List<Integer> idEstudiantes = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			idEstudiantes.add(i);
		}
		
		idEstudiantes.forEach(numero -> System.out.println("Estudiante: "+numero));
		
		
		// Procesar cada estudiante
		long tiempoInicial = System.currentTimeMillis();
		List<String> listaFinal = idEstudiantes.parallelStream().map(id -> procesarIdEstudiante(id))
				.collect(Collectors.toList());
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		listaFinal.forEach(cadena -> System.out.println(cadena));
		System.out.println("Tiempo transcurrido en segundos: "+tiempoTranscurrido);
		
	}
	
	public static String procesarIdEstudiante(Integer idEstudiante) {
		//Convertir a String
		String idConvertido = "E"+idEstudiante.toString();
		
		//Insertar en la DB
		System.out.println("Insertando estudiante: "+idConvertido+ " hilo " +Thread.currentThread().getName());
		
		// se demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return idConvertido;
	}

}
