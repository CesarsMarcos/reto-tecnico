package com.reto.tecnico.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MonedaDto {

	private long id;

	private String divisa;

	private String codigo;

	private float cotizacion;

	private Boolean estado;

}
