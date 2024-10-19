package com.reto.tecnico.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reto.tecnico.model.dto.TipoCambioDto;
import com.reto.tecnico.model.entity.TipoCambio;
import com.reto.tecnico.model.request.OperacionRequest;
import com.reto.tecnico.service.ITipoCambioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("tipoCambio")
@RequiredArgsConstructor
public class TipoCambioController {

	private final ITipoCambioService tipoCambioService;
	
	@ApiOperation( value = "Realiza las operaciones de cambio de divisa", response = TipoCambio.class)
	@ApiResponse(responseCode = "201")
	@PostMapping
	public Mono<ResponseEntity<TipoCambioDto>> calcular (
			@RequestParam ("origen") Long  origen,
			@RequestParam ("destino") Long destino,
			@Valid @RequestBody OperacionRequest operacion){
	
		return tipoCambioService.registrar(operacion, origen, destino)
				.map(tipoCambio -> new ResponseEntity<>(tipoCambio, HttpStatus.CREATED));
	}
	
	
	@DeleteMapping("{id}")
	public Mono<ResponseEntity<Void>> eliminar(@PathVariable Long id){
		return tipoCambioService.obtenerPorId(id)
				.flatMap(tipo ->{
					return tipoCambioService.eliminar(id)
							.then(Mono.just(ResponseEntity.noContent().build()));
				});
	}
	
}
