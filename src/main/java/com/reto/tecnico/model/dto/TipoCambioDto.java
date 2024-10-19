package com.reto.tecnico.model.dto;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


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

	@Min(value = 3)

	private double monto;

	private double nuevoMonto;

	private String monedaOrigen;

	private String monedaDestino;


}
