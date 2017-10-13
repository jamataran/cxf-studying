package com.arrobaautowired.demows.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arrobaautowired.services.helloworld.HelloWorldPortType;
import com.arrobaautowired.types.helloworld.Greeting;
import com.arrobaautowired.types.helloworld.ObjectFactory;
import com.arrobaautowired.types.helloworld.Person;

/**
 * @author jose.mataran
 *
 */
@Component
public class HelloWorldClient {

	@Autowired
	private HelloWorldPortType helloWorldProxy;

	public String hola(String firstName, String lastName) {

		ObjectFactory factory = new ObjectFactory();
		Person p = factory.createPerson();
		p.setFirstName(firstName);
		p.setLastName(lastName);

		Greeting response = helloWorldProxy.sayHello(p);
		return response.getGreeting();

	}

}
