package com.reto.tecnico.service;

import com.reto.tecnico.model.entity.Usuario;
import com.reto.tecnico.security.User;

import reactor.core.publisher.Mono;

public interface IUsuarioService {
	
	Mono<User> buscarPorUsuario(String usuario);

	Mono<Usuario> registrar(Usuario usuario);
	
	
	
}
