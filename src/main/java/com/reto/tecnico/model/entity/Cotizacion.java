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
@Table(name="cotizaciones")
public class Cotizacion {
	
	@Id
	private Long id;
	
	//moneda id
	private Long origen; 
	
	//moneda id
	private Long destino;
	
	private double monto;
	
	
}
