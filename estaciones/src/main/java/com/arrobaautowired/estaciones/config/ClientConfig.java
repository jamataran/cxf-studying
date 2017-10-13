package com.arrobaautowired.estaciones.config;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.webservicex.GeoIPServiceSoap;

/**
 * @author jose.mataran
 *
 */
@Configuration
public class ClientConfig {
	
	@Value("${client.address}")
	private String address;
	
	@Bean(name="wsClientProxy")
	public GeoIPServiceSoap wsClientProxy() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
	    jaxWsProxyFactoryBean.setServiceClass(GeoIPServiceSoap.class);
	    jaxWsProxyFactoryBean.setAddress(address);

	    return (GeoIPServiceSoap) jaxWsProxyFactoryBean.create();
	}

}
