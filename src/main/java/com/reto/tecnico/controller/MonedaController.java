package com.reto.tecnico.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@ApiResponse(responseCode = "201")
	@PostMapping
	public Mono<ResponseEntity<MonedaDto>> registrar (@Valid @RequestBody MonedaRequest moneda){
		return monedaService.registrar(moneda)
				.map(tipoCambio -> new ResponseEntity<MonedaDto>(tipoCambio, HttpStatus.CREATED));	
	}
	
	@PutMapping("/{id}")
	public Mono<ResponseEntity<MonedaDto>> modificar(@PathVariable Long id,  @Valid @RequestBody MonedaRequest monedaRequest){
		return monedaService.modificar(id, monedaRequest)
				.map(moneda ->
				ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(moneda));
	}
	
	@ApiOperation( value = "Obtener Monedas por Id", response = Moneda.class)
	@ApiResponse(responseCode = "200")
	@GetMapping("{id}")
	public Mono<ResponseEntity<MonedaDto>> obtenerPorId(@PathVariable ("id") Long id) {
		return monedaService.obtenerPorId(id)
		.map(m-> 
			ResponseEntity.ok()
			.contentType(MediaType.APPLICATION_JSON)
			.body(m))
		   .defaultIfEmpty(ResponseEntity.notFound().build());
		   //.switchIfEmpty(Mono.error(new PostNotFoundException(id)));
	}
	
	@ApiOperation( value = "Buscar Monedas Por Codigo de Moneda", response = Moneda.class)
	@ApiResponse(responseCode = "200")
	@GetMapping("/buscar")
	public Mono<ResponseEntity<MonedaDto>> buscarPorCodigo(@RequestParam("codigo") String codigo) {
		return monedaService.buscar(codigo)
			.map(m -> ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(m))
			.defaultIfEmpty(ResponseEntity.notFound().build());
			//.switchIfEmpty(Mono.error(NotFoundException("User not found")));
	}

}
