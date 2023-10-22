package com.reto.tecnico.service;

import com.reto.tecnico.model.entity.TipoCambio;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITipoCambioService {

	 Flux<TipoCambio> listar();
	
	 Mono<TipoCambio> guardar(TipoCambio tipo);

	 Mono<TipoCambio> modificar(Long id, TipoCambio tipoCambio);

	 Mono<TipoCambio> obtenerPorId(Long id);

	 Mono<Void> eliminar(Long id);

}
