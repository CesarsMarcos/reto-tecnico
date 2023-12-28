package com.reto.tecnico.model.dto;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TipoCambioDto {

	/*private Long id;
	
	private String descripcion;

	private float cotizacion;*/

	private Long id;

	private double monto;

	private double nuevoMonto;

	private String monedaOrigen;
	
	private String monedaDestino;


}
