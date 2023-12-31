package com.reto.tecnico.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "tipo_cambios")
public class TipoCambio {

	@Id
	private Long id;

	private double monto;

	private double nuevoMonto;

	private String monedaOrigen;
	
	private String monedaDestino;

	

}
