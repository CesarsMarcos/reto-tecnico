package com.reto.tecnico.service;


import com.reto.tecnico.model.entity.Moneda;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMonedaService {
	
	Flux<Moneda> listar();
	
	Mono<Moneda> obtenerPorCodigo(String codigo);

	Mono<Moneda> registrar(Moneda moneda);

	Mono<Moneda> obtenerPorId(Long id);
	
	Mono<Moneda> eliminar(Long id);
	
	Mono<Moneda> buscar (String codigo);
	
}
