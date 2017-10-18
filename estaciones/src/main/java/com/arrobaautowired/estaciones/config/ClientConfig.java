package com.arrobaautowired.estaciones.config;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceHttpGet;

/**
 * @author jose.mataran
 *
 */
@Configuration
public class ClientConfig {
	
	@Value("${client.address}")
	private String address;
	
	
	@Bean(name="wsClientProxy")
	public GeoIPServiceHttpGet wsClientProxy() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
	    jaxWsProxyFactoryBean.setServiceClass(GeoIPService.class);
	    jaxWsProxyFactoryBean.setAddress(address);

	    return (GeoIPServiceHttpGet) jaxWsProxyFactoryBean.create();
	}

}
