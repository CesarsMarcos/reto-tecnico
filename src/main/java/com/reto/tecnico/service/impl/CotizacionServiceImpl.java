package com.reto.tecnico.service.impl;

import org.springframework.stereotype.Service;

import com.reto.tecnico.model.entity.Cotizacion;
import com.reto.tecnico.repository.CotizacionRepository;
import com.reto.tecnico.service.ICotizacionService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CotizacionServiceImpl implements ICotizacionService{
	
	private final CotizacionRepository cotizacionRepo;
	
	@Override
	public Mono<Cotizacion> obtenerPorOrginDestino(Long idOrigen, Long idDestino) {

		return cotizacionRepo.findByOrigenAndDestino(idOrigen, idDestino);
	}

}
