package com.reto.tecnico.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class MonedaRequest {

	private long id;

	private String descripcion;

	private String codigo;

	private float cotizacion;

	private Boolean estado;

}
