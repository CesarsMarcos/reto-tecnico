package com.reto.tecnico.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.reto.tecnico.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "usuarios")
public class Usuario {

	@Id
	private String id;

	private String usuario;

	private String password;

	private Boolean estado;

	private Role rol;


}
