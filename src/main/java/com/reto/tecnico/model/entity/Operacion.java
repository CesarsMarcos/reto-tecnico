package com.reto.tecnico.model.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Operacion {

	@Id
	private Long id;

	private float monto;

	private float nuevoMonto;

	private String monedaDestino;

	private String monedaOrigen;

}
