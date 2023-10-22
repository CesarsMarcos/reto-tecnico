package com.reto.tecnico.service;

import com.reto.tecnico.model.request.OperacionRequest;
import com.reto.tecnico.model.response.OperacionResponse;

import reactor.core.publisher.Mono;

public interface ITransaccionService {

	public Mono<OperacionResponse> registrar(OperacionRequest request, Long origen, Long destino );
	
	
	
	
}
