package com.reto.tecnico.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.reto.tecnico.model.entity.Moneda;

import reactor.core.publisher.Mono;

public interface MonedaRepository extends ReactiveCrudRepository<Moneda, Long>{
	
	Mono<Moneda> findMonedaByCodigoContainingIgnoreCase(String codigo);

}
