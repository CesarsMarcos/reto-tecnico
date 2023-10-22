package com.reto.tecnico.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OperacionResponse {

	private float monto;
	
	private float nuevoMonto;
	
	private String  monedaDestino;
	
	private String monedaOrigen;
	
	
}
