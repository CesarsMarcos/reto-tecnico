package com.reto.tecnico.service;

import com.reto.tecnico.model.entity.TipoCambio;
import com.reto.tecnico.model.request.OperacionRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITipoCambioService {

	Flux<TipoCambio> listar();

	Mono<TipoCambio> registrar(OperacionRequest request, Long origen, Long destino);

	Mono<TipoCambio> obtenerPorId(Long id);

	Mono<Void> eliminar(Long id);

}
