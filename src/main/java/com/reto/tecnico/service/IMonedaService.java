package com.reto.tecnico.service;


import com.reto.tecnico.model.dto.MonedaDto;
import com.reto.tecnico.model.entity.Moneda;
import com.reto.tecnico.model.request.MonedaRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMonedaService {
	
	Flux<MonedaDto> listar();
	
	Mono<Moneda> obtenerPorCodigo(String codigo);

	Mono<MonedaDto> registrar(MonedaRequest moneda);

	Mono<MonedaDto> obtenerPorId(Long id);
	
	Mono<Void> eliminar(Long id);
	
	Mono<MonedaDto> buscar (String codigo);
	
}
