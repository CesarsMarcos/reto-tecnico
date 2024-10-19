package com.reto.tecnico.model.dto;


import javax.validation.constraints.NotNull;

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
	
	private long modenaOrigen;
	
	private long monedaDestino;

	private float montoFinal;
	
	
}
