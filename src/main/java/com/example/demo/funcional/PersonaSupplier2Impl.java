package com.example.demo.funcional;

public class PersonaSupplier2Impl implements IPersonaSupplier<Persona> {

	@Override
	public Persona getNombre() {
		Persona per = new Persona();
		per.setApellido("Estrella1");
		per.setNombre("Juan1");
		return	per;
	}

}
