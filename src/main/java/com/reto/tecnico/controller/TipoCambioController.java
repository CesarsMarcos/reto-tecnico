package com.reto.tecnico.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	@ApiResponse(responseCode = "200")
	@PostMapping
	public Mono<ResponseEntity<TipoCambio>> calcular (
			@RequestParam ("origen") Long  origen,
			@RequestParam ("destino") Long destino,
			@RequestBody OperacionRequest operacion){
	
		return tipoCambioService.registrar(operacion, origen, destino)
				.map(tipoCambio -> new ResponseEntity<>(tipoCambio, HttpStatus.CREATED));
	}
	


}
