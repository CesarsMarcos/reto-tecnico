package com.reto.tecnico.service.impl;

import org.springframework.stereotype.Service;

import com.reto.tecnico.model.dto.CotizacionDto;
import com.reto.tecnico.model.entity.Cotizacion;
import com.reto.tecnico.model.mappers.CotizacionMapper;
import com.reto.tecnico.model.request.CotizacionRequest;
import com.reto.tecnico.repository.CotizacionRepository;
import com.reto.tecnico.service.IMatrizCotizacionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatrizCotizacionServiceImpl implements IMatrizCotizacionService {

	private final CotizacionRepository cotizacionRepo;
	
	private final CotizacionMapper cotizacionMapper;

	@Override
	public Mono<Cotizacion> obtenerPorOrginDestino(Long idOrigen, Long idDestino) {
		return cotizacionRepo.findByOrigenAndDestino(idOrigen, idDestino);
	}
	
	@Override
	public Mono<CotizacionDto> registro(CotizacionRequest cotizacion) {
		return cotizacionRepo.save(Cotizacion.builder()
				.destino(cotizacion.getDestino())
				.origen(cotizacion.getOrigen())
				.monto(cotizacion.getMonto()).build())
				.doOnSuccess(c -> log.info(":: Registro de cotización:: ", cotizacion))
				.map(cotizacionMapper:: mapToCotizacionDto);
	}

	@Override
	public Flux<CotizacionDto> matriz() {
		return cotizacionRepo.findAll()
				.map(cotizacionMapper::mapToCotizacionDto);
	}

}
