package com.reto.tecnico.service.impl;

import org.springframework.stereotype.Service;

import com.reto.tecnico.model.dto.MonedaDto;
import com.reto.tecnico.model.entity.Moneda;
import com.reto.tecnico.model.mappers.MonedaMapper;
import com.reto.tecnico.model.request.MonedaRequest;
import com.reto.tecnico.repository.MonedaRepository;
import com.reto.tecnico.service.IMonedaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class MonedaServiceImpl implements IMonedaService {

	private final MonedaRepository monedaRepo;
	
	private final MonedaMapper mapper;

	@Override
	public Flux<MonedaDto> listar() {
		return monedaRepo.findAll()
				.doOnNext(moneda-> log.info("", moneda))
				.map(mapper::mapToMonedaDto);
	}

	@Override
	public Mono<Moneda> obtenerPorCodigo(String codigo) {
		return monedaRepo.findMonedaByCodigoContainingIgnoreCase(codigo);
	}

	@Override
	public Mono<MonedaDto> registrar(MonedaRequest moneda) {
		return monedaRepo.save( Moneda.builder()
				.codigo(moneda.getCodigo())
				.cotizacion(moneda.getCotizacion())
				.descripcion(moneda.getDescripcion())
				.estado(moneda.getEstado())
				.build())
				.doOnSuccess(prod -> log.info("Producto editado: {}", prod))
				.map(mapper::mapToMonedaDto);
				
	}

	@Override
	public Mono<MonedaDto> obtenerPorId(Long id) {
	
		return null;
	}

	@Override
	public Mono<MonedaDto> buscar(String codigo) {
		//return monedaRepo.findMonedaByCodigoContainingIgnoreCase(codigo);
		return null;
	}

	@Override
	public Mono<Void> eliminar(Long id) {
		
		/*return monedaRepo.findById(id).flatMap(monedaSave -> {
			monedaSave.setEstado(false);
			return monedaRepo.save(monedaSave);
		});*/
		
		

	}

}
