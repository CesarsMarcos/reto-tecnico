package com.reto.tecnico.service;

import com.reto.tecnico.security.User;

import reactor.core.publisher.Mono;

public interface IUsuarioService {
	
	Mono<User> buscarPorUsuario(String username);

	
}
