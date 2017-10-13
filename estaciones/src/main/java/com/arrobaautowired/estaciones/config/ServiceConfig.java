package com.arrobaautowired.estaciones.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arrobaautowired.estaciones.service.IPServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jose.mataran
 *
 */
@Configuration
@Slf4j
public class ServiceConfig {
	
	@Autowired
	private SpringBus bus;
	
	@Value("${ipservice.path}")
	private String path;
	
	/**
	 * Metodo que publicara el endPoint para el servicio que voy a crear.
	 * Se construira con
	 * <ul>
	 * 	<li>{@link Bus}</li>
	 * 	<li>{@link IPServiceImpl }</li>
	 * </ul>*/
	@Bean
	public Endpoint endPoint() {
		Endpoint endPointImpl= new EndpointImpl(bus, new IPServiceImpl());
		endPointImpl.publish(path);
		
		log.info("Cargando {}", endPointImpl);
		return endPointImpl;
	}

}
