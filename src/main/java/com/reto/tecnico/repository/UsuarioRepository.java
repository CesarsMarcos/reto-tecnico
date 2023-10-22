package com.reto.tecnico.repository;

import java.util.Optional;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.reto.tecnico.model.entity.Usuario;

import reactor.core.publisher.Mono;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario,Long> {

	Optional<Usuario> findByUsuario(String username);

	Mono<Usuario> findOneByUsuario(String usuario);

}
