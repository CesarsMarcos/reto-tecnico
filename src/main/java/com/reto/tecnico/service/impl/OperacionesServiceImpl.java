package com.reto.tecnico.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reto.tecnico.model.entity.Moneda;
import com.reto.tecnico.model.request.OperacionRequest;
import com.reto.tecnico.model.response.OperacionResponse;
import com.reto.tecnico.repository.MonedaRepository;
import com.reto.tecnico.service.ITransaccionService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OperacionesServiceImpl implements ITransaccionService{

	
	private final MonedaRepository monedaRepo;
	
	@Override
	public Mono<OperacionResponse> registrar(OperacionRequest request, Long origen, Long destino ) {
		

		//El sistema debe poder realizar un tipo de cambio a un monto
		//donde se deben utilizar el monto, moneda de origen, moneda de destino, monto con el tipo de campo y el tipo de cambio.
		//Debe Permitir el registro, actualización y búsqueda del tipo de cambio.

		
		
	  Mono<Optional<Moneda>> origenSave =	monedaRepo.findById(origen).map(Optional::of).defaultIfEmpty(Optional.empty());
		  
	  Mono<Optional<Moneda>> destinoSave =	monedaRepo.findById(destino).map(Optional::of).defaultIfEmpty(Optional.empty());

	  
		
		
		OperacionResponse response =  OperacionResponse.builder().monedaDestino("")
		.monedaOrigen("")
		.monto(15f).build();
		
	
		return  Mono.just(response) ; //transaccionRepo.save(transaccion);
	}


	public double convertir (double valor, String pais) {
		
        double cantidadMoneda=0;
        double dolares = cantidadMoneda /valor;
		dolares =(double) Math.round(dolares * 100d) /100;
		
		return dolares;
		
	}
	



}
