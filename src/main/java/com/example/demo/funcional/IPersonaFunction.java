package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaFunction<R, T> {

	// La función recibe un tipo de argumento, lo procesa y devuelve OTRO tipo de dato.

	public R aplicar(T arg1);
	
}
