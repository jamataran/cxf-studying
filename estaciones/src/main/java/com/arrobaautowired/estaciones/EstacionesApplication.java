package com.arrobaautowired.estaciones;

import java.util.Arrays;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;
import net.webservicex.GeoIPServiceHttpGet;

@Slf4j
@SpringBootApplication
@ComponentScan({"net.webservicex", "com.arrobaautowired"})
public class EstacionesApplication extends SpringBootServletInitializer implements CommandLineRunner{
	
	@Autowired
    private ApplicationContext appContext;


	public static void main(String[] args) {
		SpringApplication.run(EstacionesApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("\n\n\n\nBEANS");
		String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            log.info("\tBean leido: {}", bean);
        }
		
	}
	
	@Value("${client.address}")
	private String address;
	
	@Bean(name="wsClientProxy")
	public GeoIPServiceHttpGet wsClientProxy() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
	    jaxWsProxyFactoryBean.setServiceClass(GeoIPServiceHttpGet.class);
	    jaxWsProxyFactoryBean.setAddress(address);

	    return (GeoIPServiceHttpGet) jaxWsProxyFactoryBean.create();
	}
	
}
