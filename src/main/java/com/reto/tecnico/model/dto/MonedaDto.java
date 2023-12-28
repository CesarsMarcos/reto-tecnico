package com.reto.tecnico.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class MonedaDto {

	private long id;
	
	private String descripcion;
	
	private String codigo;
	
	private float cotizacion;
	
	private Boolean estado;
	
}
