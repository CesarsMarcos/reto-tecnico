package com.reto.tecnico.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MonedaRequest  implements Serializable{


	@NotBlank
	private String descripcion;

	@NotBlank
	private String codigo;

	@NotNull
	private float cotizacion;

	private Boolean estado;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2409497880211991516L;
}
