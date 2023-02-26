package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainInterfacesFuncionales {

	// Impresión de consola más detallada, con hora, paquetes y clase donde imprime.
	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		
	//SUPPLIER
		LOG.info("1. SUPPLIER");
		// CLASES:
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier Clase:"+ supplier1.getNombre());
		
		IPersonaSupplier<Persona> supplier5 = new PersonaSupplier2Impl();
		LOG.info("Supplier Clase:"+ supplier5.getNombre());
		
		
		
		// LAMDAS:
		IPersonaSupplier<String> supplier2 = () -> "Edison2";
		LOG.info("Supplier Lambda:"+ supplier2.getNombre());
		
		IPersonaSupplier<Integer> supplier3 = () -> Integer.valueOf(5);
		LOG.info("Supplier Lambda:"+ supplier3.getNombre());
		
		IPersonaSupplier<Persona> supplier4 = () -> {
			Persona per = new Persona();
			per.setApellido("Estrella");
			per.setNombre("Juan");
			return	per;
			};
		LOG.info("Supplier Lambda:"+ supplier4.getNombre());
		
		
	//CONSUMER
		LOG.info("2. CONSUMER");
		// CLASES: (le puso 2 genéricos, pero si hay uno, todo bien.)
		IPersonaConsumer<String, Integer> consumer1 = new PersonaConsumerImpl();
		consumer1.accept("Procesa este dato", Integer.valueOf(10)); 
		
		// LAMDAS:
		IPersonaConsumer<String, Integer> consumer2 = (cadena, numero) -> {
			LOG.info("mensaje a: "+cadena);
			LOG.info("mensaje b: "+cadena);
			LOG.info("mensaje c: "+numero);
			};
		consumer2.accept("Procesa este dato 2:", Integer.valueOf(15));
		
		
		IPersonaConsumer<Integer, Integer> consumer3 = (valor1, valor2) -> {
			Integer valor3 = valor1.intValue()+valor2.intValue();
			LOG.info("Valor 3 = "+valor3 );
		};
		consumer3.accept(Integer.valueOf(5), Integer.valueOf(10));
	
		
	//PREDICATE
		LOG.info("3. PREDICATE");
		
		IPersonaPredicate<String> predicate1 = cadena -> cadena.contains("Z"); 
		LOG.info("Predicate :"+predicate1.evaluar("EdisonZ"));

		IPersonaPredicate<Integer> predicate2 = numero -> {
			if (numero.intValue()>10) {
				return true;
			}else {
				return false;
			}
		}; 
		LOG.info("Predicate :"+predicate2.evaluar(Integer.valueOf(11)));
		
		
		
		
	//FUNCTION
		LOG.info("4. FUNCTION");
		
		// Ejemplo 1:
					  //<Retorno, Parámetro>
		IPersonaFunction<String, Integer> function1 = numero -> "Valor: "+numero.toString();
		LOG.info(function1.aplicar(10));
		
		
		// Ejemplo 2:
					  //<Retorno, Parámetro>
		IPersonaFunction<Ciudadano, Persona> function2 = per -> {
			Ciudadano ciu = new Ciudadano();
			ciu.setNombreCompleto(per.getNombre()+" "+per.getApellido());
			ciu.setCiudad("Quito");
			return ciu;
		};
		Persona per1 = new Persona();
		per1.setNombre("Juan");
		per1.setApellido("Estrella C");
		Ciudadano ciudadanoConvertido = function2.aplicar(per1);
		
		LOG.info("Ciudadano Convertido:"+ ciudadanoConvertido);
		
		
		
		
		//FUNCTION
		LOG.info("5. UNARY OPERATOR");
		
		IPersonaUnaryOperator<String> unaryOperator = cadena -> {
			String cadenaFinal = cadena.concat("sufijo");
			return cadenaFinal;
		};
		String cad = unaryOperator.aplicar("Daniel");
		LOG.info("Unary Operator: "+ cad);
		
		
		
		
		
		
		

	}
}
