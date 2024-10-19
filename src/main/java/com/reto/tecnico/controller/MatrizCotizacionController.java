package com.reto.tecnico.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.tecnico.model.dto.CotizacionDto;
import com.reto.tecnico.model.request.CotizacionRequest;
import com.reto.tecnico.model.response.AuthResponse;
import com.reto.tecnico.service.IMatrizCotizacionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("cotizaciones")
@RequiredArgsConstructor
public class MatrizCotizacionController {
	
	private final IMatrizCotizacionService cotizacionService;
	
	@ApiOperation( value = "Matriz de Cotizaciones", response = AuthResponse.class)
	@ApiResponse(responseCode = "200")
	@GetMapping
	public Mono<ResponseEntity<Flux<CotizacionDto>>> listar() {
		Flux<CotizacionDto> fxLista = cotizacionService.matriz();
		return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(fxLista));
	}
	
	@ApiResponse(responseCode = "201")
	@PostMapping
	public Mono<ResponseEntity<CotizacionDto>>  registro(@Valid @RequestBody CotizacionRequest cotizacionRequest ){
		return cotizacionService.registro(cotizacionRequest)
				.map(co -> 
					new ResponseEntity<CotizacionDto>(co, HttpStatus.CREATED));
	}
	
	
}
