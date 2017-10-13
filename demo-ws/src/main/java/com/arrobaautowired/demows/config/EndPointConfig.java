package com.arrobaautowired.demows.config;

import org.apache.cxf.Bus;
import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arrobaautowired.demows.service.HelloWorldImpl;

/**
 * 
 * Esta clase creara la definicion de nuestro EndPoint, la cual expondra el servicio SOAP.
 * Para crearlo utilizara el {@link Bus} que maneja los mensajes entrantes / salientes y las cadenas 
 * de interceptores.
 * 
 * @author jose.mataran
 *
 */
@Configuration
public class EndPointConfig {
	
	@Autowired
	private Bus bus;
	
	@Value("${helloworld.path}")
	private String path;
	
	@Bean
	public Endpoint endPoint() {
		// El endPoint se publica utilizando el bus y la implementacion del servicio.
		Endpoint endpoint = new EndpointImpl(bus, new HelloWorldImpl());
		
		// Sobre que ruta se publicara en el endPoint
		endpoint.publish(path);
		
		return endpoint;
	}

}
