package com.reto.tecnico.model.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.reto.tecnico.model.Rol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Usuario {

	@Id
	private Long id;

	private String nombres;

	private String usuario;

	private String password;

	private Rol rol;

	private Boolean estado;

	
}
