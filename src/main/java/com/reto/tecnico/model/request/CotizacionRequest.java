package com.reto.tecnico.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CotizacionRequest {

	@NotNull
	//moneda id
	private Long origen; 
	
	@NotNull
	//moneda id
	private Long destino;
	
	
	@Min(value = 1)
	@NotNull
	private double monto;
            
}
