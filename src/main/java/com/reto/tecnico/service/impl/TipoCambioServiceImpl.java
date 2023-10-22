package com.reto.tecnico.service.impl;

import org.springframework.stereotype.Service;

import com.reto.tecnico.model.entity.TipoCambio;
import com.reto.tecnico.repository.TipoCambioRepository;
import com.reto.tecnico.service.ITipoCambioService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TipoCambioServiceImpl implements ITipoCambioService {

	private final TipoCambioRepository tipoCambioRepo;
	

	@Override
	public Flux<TipoCambio> listar() {
		return tipoCambioRepo.findAll();
	}
	
	@Override
	public Mono<TipoCambio> guardar(TipoCambio tipo) {
		return tipoCambioRepo.save(tipo);
	}

	@Override
	public Mono<TipoCambio> modificar(Long id, TipoCambio tipo) {
		return tipoCambioRepo.save(tipo);
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
