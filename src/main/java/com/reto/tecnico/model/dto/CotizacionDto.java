package com.reto.tecnico.model.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class CotizacionDto {
	
	private Long id;
	
	//moneda id
	private Long origen; 

	//moneda id
	private Long destino;
	
	
	private double monto;
	
	
}
