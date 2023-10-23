package com.reto.tecnico.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@Table(name="monedas")
public class Moneda {
	
	@Id
	private long id;
	
	private String descripcion;
	
	private String codigo;
	
	private float cotizacion;
	
	private Boolean estado;
	
}
