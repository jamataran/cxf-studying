package com.arrobaautowired.estaciones.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IPServiceResponse {
	
	private String codigoCiudad;
	
	private String nombreCiudad;
	
	private String ipEvaluada;
	
	private LocalDateTime respuestaEnviada;

}
