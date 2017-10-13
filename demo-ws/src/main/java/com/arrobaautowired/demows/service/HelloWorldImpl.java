package com.arrobaautowired.demows.service;

import com.arrobaautowired.services.helloworld.HelloWorldPortType;
import com.arrobaautowired.types.helloworld.Greeting;
import com.arrobaautowired.types.helloworld.Person;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jose.mataran
 *
 *
 */
@Slf4j
public class HelloWorldImpl implements HelloWorldPortType {

	/* (non-Javadoc)
	 * @see com.arrobaautowired.services.helloworld.HelloWorldPortType#sayHello(com.arrobaautowired.types.helloworld.Person)
	 */
	@Override
	public Greeting sayHello(Person person) {
		log.debug("Persona recibida {}", person);
		Greeting saludo=new Greeting();
		saludo.setGreeting(new StringBuilder().append(person.getFirstName()).append(" ").append("¡HOLA!").toString());

		return saludo;
	}

}
