package com.example.demo.funcional;

@FunctionalInterface
public interface IPersona {
	
	// El único requisito que debe tener una interface funcional es que tenga un solo método. La buena práctica es
	// que tenga la anotación @FunctionalInterface
	public String comer();

}
