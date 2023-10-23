package com.reto.tecnico.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.reto.tecnico.model.entity.Cotizacion;

import reactor.core.publisher.Mono;

public interface CotizacionRepository extends ReactiveCrudRepository<Cotizacion, Long> {

	Mono<Cotizacion> findByOrigenAndDestino(Long idOrigen, Long idDestino);

}
