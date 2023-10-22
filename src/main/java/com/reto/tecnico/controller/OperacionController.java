package com.reto.tecnico.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reto.tecnico.model.dto.CalculoDto;
import com.reto.tecnico.service.ITransaccionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("transaccion")
@RequiredArgsConstructor
public class OperacionController {
	
	private final ITransaccionService transaccionService;
	
	
	@PostMapping()
	public ResponseEntity<?> calcular (@RequestParam ("origen") Long origen, @RequestParam ("destino") Long destino, @RequestBody CalculoDto calculo){
		
		
		
		return null;
		
	}
	
	
}
