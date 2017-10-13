package com.arrobaautowired.demows.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arrobaautowired.services.helloworld.HelloWorldPortType;

/**
 * @author jose.mataran
 * 
 * CXF nos aporta {@link JaxWsProxyFactoryBean}, esta clase creara un cliente para el servicio el cual podremos implementar.
 * La siguietne clase creara un bean (helloWorldProxy) que nos permitira invocar al servicio.
 *
 */
@Configuration
public class ClienteConfig {
	
	@Value("${client.url}")
	private String address;
	
	@Bean(name="helloWorldProxy")
	public HelloWorldPortType helloWorldProxy() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
	    jaxWsProxyFactoryBean.setServiceClass(HelloWorldPortType.class);
	    jaxWsProxyFactoryBean.setAddress(address);

	    return (HelloWorldPortType) jaxWsProxyFactoryBean.create();
	}

}
