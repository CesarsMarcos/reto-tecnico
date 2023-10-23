package com.reto.tecnico.service.impl;

import org.springframework.stereotype.Service;

import com.reto.tecnico.model.entity.Moneda;
import com.reto.tecnico.repository.MonedaRepository;
import com.reto.tecnico.service.IMonedaService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MonedaServiceImpl implements IMonedaService {

	private final MonedaRepository monedaRepo;

	@Override
	public Flux<Moneda> listar() {
		return monedaRepo.findAll();
	}

	@Override
	public Mono<Moneda> obtenerPorCodigo(String codigo) {
		return monedaRepo.findMonedaByCodigoContainingIgnoreCase(codigo);
	}

	@Override
	public Mono<Moneda> registrar(Moneda moneda) {
		return monedaRepo.save(moneda);
	}

	@Override
	public Mono<Moneda> obtenerPorId(Long id) {
		return monedaRepo.findById(id);
	}

	@Override
	public Mono<Moneda> buscar(String codigo) {
		return monedaRepo.findMonedaByCodigoContainingIgnoreCase(codigo);
	}

	@Override
	public Mono<Moneda> eliminar(Long id) {
		return monedaRepo.findById(id).flatMap(monedaSave -> {
			monedaSave.setEstado(false);
			return monedaRepo.save(monedaSave);
		});

	}

}
