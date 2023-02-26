package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaSupplier<T> {
	
	// La función no necesita ningún parámetro pero sí devuelve un tipo de dato determinado.

	public T getNombre();
	
}
