package com.reto.tecnico.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OperacionResponse {

	private double monto;
	
	private double nuevoMonto;
	
	private String  monedaDestino;
	
	private String monedaOrigen;
	
	
}
