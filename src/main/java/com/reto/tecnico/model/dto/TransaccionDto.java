package com.reto.tecnico.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TransaccionDto {

	private long idTransaccion;
	
	private float monto;
	
	private float modenaOrigen;
	
	private float monedaDestino;
	
	private float montoFinal;
	
	
}
