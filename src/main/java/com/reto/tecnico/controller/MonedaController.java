package com.reto.tecnico.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reto.tecnico.model.dto.MonedaDto;
import com.reto.tecnico.model.entity.Moneda;
import com.reto.tecnico.model.request.MonedaRequest;
import com.reto.tecnico.service.IMonedaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("monedas")
@RequiredArgsConstructor
public class MonedaController {
	
	private final IMonedaService monedaService;
	
	@ApiOperation( value = "Listado de Monedas", response = Moneda.class)
	@ApiResponse(responseCode = "200")
	@GetMapping
	public Mono<ResponseEntity<Flux<MonedaDto>>> listar(/*@RequestParam ("descripcion") String  descripcion*/) {
		Flux<MonedaDto> fxLista = monedaService.listar();
		return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(fxLista));
	}
	
	@ApiOperation( value = "Registro de Moendas", response = Moneda.class)
	@ApiResponse(responseCode = "204")
	@PostMapping
	public Mono<Object> registrar (
			@RequestBody MonedaRequest moneda){
		return monedaService.registrar(moneda)
				.map(tipoCambio -> new ResponseEntity<>(moneda, HttpStatus.CREATED));	
	}
	
	@ApiOperation( value = "Obtener Monedas por Id", response = Moneda.class)
	@ApiResponse(responseCode = "200")
	@GetMapping("{id}")
	public Mono<ResponseEntity<Mono<MonedaDto>>> obtenerPorId(@PathVariable ("id") Long id) {
		Mono<MonedaDto>  moneda = monedaService.obtenerPorId(id);
		return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(moneda));
	}
	
	@ApiOperation( value = "Buscar Monedas Por Codigo de Moenda", response = Moneda.class)
	@ApiResponse(responseCode = "200")
	@GetMapping("/buscar")
	public Mono<ResponseEntity<Mono<MonedaDto>>> buscarPorCodigo(@RequestParam("codigo") String codigo) {
		Mono<MonedaDto>  moneda = monedaService.buscar(codigo); 
		return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(moneda));
	}

}
