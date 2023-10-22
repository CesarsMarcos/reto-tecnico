package com.reto.tecnico.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TipoCambioDto {

	private Long id;
	
	@NotBlank
	private String descripcion;

	@NotBlank
	private float cotizacion;

}
