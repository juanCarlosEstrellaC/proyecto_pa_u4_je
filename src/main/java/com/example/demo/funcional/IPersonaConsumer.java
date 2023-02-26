package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaConsumer<T, R> {

	// La función recibe una variable genérica, realiza una operación con ella y NO retorna ningún resultado.
	
	public void accept(T arg1, R arg2);
}
