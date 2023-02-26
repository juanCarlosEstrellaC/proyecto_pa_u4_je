package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonaConsumerImpl implements IPersonaConsumer<String, Integer> {

	private static final Logger LOG = LoggerFactory.getLogger(PersonaConsumerImpl.class);
	
	@Override
	public void accept(String arg1, Integer arg2) {
		LOG.info("mensaje: "+arg1);
		LOG.info("mensaje2: "+arg2);
	}

}
