package com.reto.tecnico.service.impl;

import org.springframework.stereotype.Service;

import com.reto.tecnico.model.dto.TipoCambioDto;
import com.reto.tecnico.model.entity.Cotizacion;
import com.reto.tecnico.model.entity.TipoCambio;
import com.reto.tecnico.model.mappers.TipoCambioMapper;
import com.reto.tecnico.model.request.OperacionRequest;
import com.reto.tecnico.repository.CotizacionRepository;
import com.reto.tecnico.repository.MonedaRepository;
import com.reto.tecnico.repository.TipoCambioRepository;
import com.reto.tecnico.service.ITipoCambioService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class TipoCambioServiceImpl implements ITipoCambioService {

	private final TipoCambioRepository tipoCambioRepo;

	private final MonedaRepository monedaRepo;

	private final CotizacionRepository cotizacionRepo;

	private final TipoCambioMapper mapper;

	@Override
	public Mono<TipoCambioDto> registrar(OperacionRequest operacion, Long origen, Long destino) {

		// El sistema debe poder realizar un tipo de cambio a un monto
		// donde se deben utilizar el monto, moneda de origen, moneda de destino, monto
		// con el tipo de campo y el tipo de cambio.
		// Debe Permitir el registro, actualización y búsqueda del tipo de cambio.

		return monedaRepo.findById(origen).flatMap(dataOrigen -> monedaRepo.findById(destino).flatMap(dataDestino -> {
			return cotizacionRepo.findByOrigenAndDestino(origen, destino).map(Cotizacion::getMonto).map(monto -> {
				
				double nuevoMonto = operacion.getMonto() / monto;
				nuevoMonto = (double) Math.round(nuevoMonto * 100d) / 100;

				return TipoCambio.builder().monedaOrigen(dataOrigen.getDescripcion())
						.monedaDestino(dataDestino.getDescripcion()).monto(operacion.getMonto()).nuevoMonto(nuevoMonto)
						.build();
			}).flatMap(tipoCambioRepo::save)
					.doOnSuccess(tipo -> log.info("Tipo de cambio creada: {}", tipo))
					.map(mapper::mapTipoCambioDto);
		}));
	}

	@Override
	public Flux<TipoCambio> listar() {
		return tipoCambioRepo.findAll();
	}

	@Override
	public Mono<TipoCambio> obtenerPorId(Long id) {
		return tipoCambioRepo.findById(id);
	}

	@Override
	public Mono<Void> eliminar(Long id) {
		return tipoCambioRepo.deleteById(id);
	}

}
