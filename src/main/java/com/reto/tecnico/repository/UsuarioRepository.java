package com.reto.tecnico.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.reto.tecnico.model.entity.Usuario;

import reactor.core.publisher.Mono;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Long>{

	Mono<Usuario> findByUsuario(String usuario);
}
