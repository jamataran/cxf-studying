package com.arrobaautowired.estaciones.service;

import java.time.LocalDateTime;

import org.apache.cxf.spring.boot.autoconfigure.CxfAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arrobaautowired.estaciones.dto.IPServiceResponse;

import lombok.extern.slf4j.Slf4j;
import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceHttpGet;
import net.webservicex.GeoIPServiceSoap;

/**
 * @author jose.mataran
 *
 */
@Slf4j
@Service
public class IPServiceImpl implements IPService {
	
	@Autowired
	private CxfAutoConfiguration cxfAutoConfiguration; 

	@Autowired
	@Qualifier("wsClientProxy")
	private GeoIPServiceHttpGet wsClientProxy;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.arrobaautowired.estaciones.service.IPService#getIPData(java.lang.String)
	 */
	@Override
	public IPServiceResponse getIPData(String ip) {
		log.debug("Se ha recibido la direccion {}", ip);

		// Consultando al ws.
//		GeoIP ipObtenida = wsClientProxy.getGeoIP(ip);
//		log.debug("Se obtuvo {} del ws", ipObtenida);
		
		GeoIPService service = new GeoIPService();
		GeoIPServiceSoap soapService=service.getPort(GeoIPServiceSoap.class);
		GeoIP ipObtenida = soapService.getGeoIP(ip);

		IPServiceResponse response = IPServiceResponse.builder()
				.codigoCiudad(ipObtenida.getCountryCode())
				.nombreCiudad(ipObtenida.getCountryName())
				.respuestaEnviada(LocalDateTime.now())
				.ipEvaluada(ip)
				.build();

		log.debug("Se enviara {}", response);
		return response;
	}

}
