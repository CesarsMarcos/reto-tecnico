package com.reto.tecnico.service;

import com.reto.tecnico.model.dto.CotizacionDto;
import com.reto.tecnico.model.entity.Cotizacion;
import com.reto.tecnico.model.request.CotizacionRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMatrizCotizacionService {

	Flux<CotizacionDto> matriz ();
	
	Mono<Cotizacion> obtenerPorOrginDestino(Long idOrigen, Long idDestino);
	
	Mono<CotizacionDto> registro (CotizacionRequest cotizacion);
}
