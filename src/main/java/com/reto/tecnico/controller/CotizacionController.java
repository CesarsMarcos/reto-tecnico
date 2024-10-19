package com.reto.tecnico.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.tecnico.model.entity.Cotizacion;
import com.reto.tecnico.model.response.AuthResponse;
import com.reto.tecnico.repository.CotizacionRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("cotizaciones")
@RequiredArgsConstructor
public class CotizacionController {
	
	private final CotizacionRepository cotizacionRepo;
	
	@ApiOperation( value = "Cotizaciones", response = AuthResponse.class,
			notes = "Listado de cotizaciones" )
	@ApiResponse(responseCode = "200")
	@GetMapping
	public Mono<ResponseEntity<Flux<Cotizacion>>> listar() {
		Flux<Cotizacion> fxLista = cotizacionRepo.findAll();
		return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(fxLista));
	}
}
