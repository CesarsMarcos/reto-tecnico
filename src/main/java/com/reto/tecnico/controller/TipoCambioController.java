package com.reto.tecnico.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.tecnico.model.entity.TipoCambio;
import com.reto.tecnico.service.ITipoCambioService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tipoCambio/")
@RequiredArgsConstructor
public class TipoCambioController {

	private final ITipoCambioService tipoCambioService;

	@GetMapping
	public Mono<ResponseEntity<Flux<TipoCambio>>> listar() {
		Flux<TipoCambio> fxLista = tipoCambioService.listar();
		return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(fxLista));
	}

	@GetMapping("{id}")
	public Mono<ResponseEntity<TipoCambio>> obtenerPorId(@PathVariable Long id) {
		return tipoCambioService.obtenerPorId(id)
				.map(tipo -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(tipo));
	}

	@PostMapping
	public Mono<TipoCambio> guardar(@RequestBody TipoCambio tipoCambio) {
		return tipoCambioService.guardar(tipoCambio);
	}

	@PutMapping("{id}")
	public Mono<ResponseEntity<TipoCambio>> modificar(@RequestBody TipoCambio tipoCambio, @PathVariable Long id) {
		return tipoCambioService.modificar(id, tipoCambio)
				.map(tipo -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(tipo));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> eliminar( @PathVariable Long id) {
		return null;
	}

}
