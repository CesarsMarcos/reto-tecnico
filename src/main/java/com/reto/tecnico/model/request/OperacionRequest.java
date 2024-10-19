package com.reto.tecnico.model.request;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperacionRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6532460365177650626L;

	@Min(value = 3)
	@NotNull
	private double monto;

}
