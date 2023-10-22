package com.reto.tecnico.model.entity;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Moneda {
	
	@Id
	private long id;
	
	private String nomDivisa;
	
	private TipoCambio tipoCambio;
	
	private float monto;
	
}
