package com.reto.tecnico.service;

import com.reto.tecnico.model.entity.Cotizacion;

import reactor.core.publisher.Mono;

public interface ICotizacionService {

	Mono<Cotizacion> obtenerPorOrginDestino(Long idOrigen, Long idDestino);
}
