package com.arrobaautowired.estaciones.service;

import javax.jws.WebService;

import com.arrobaautowired.estaciones.dto.IPServiceResponse;

/**
 * @author jose.mataran
 *
 */
@WebService
public interface IPService {
	
	IPServiceResponse getIPData(String ip);
}
