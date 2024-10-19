package com.reto.tecnico.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reto.tecnico.model.request.AuthRequest;
import com.reto.tecnico.model.response.AuthResponse;
import com.reto.tecnico.security.JwtService;
import com.reto.tecnico.service.IUsuarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AutenticacionController {

	private final JwtService jwtUtil;

	private final IUsuarioService usuarioService;
	
	@ApiOperation( value = "Autenticacion", response = AuthResponse.class,
			notes = "Api que valida la utenticación del usuario" )
	@ApiResponse(responseCode = "200")
	@PostMapping("/login")
	public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest request) {	
		
		log.info("Usuario ingresado "+ request.getUsername());

		
		return usuarioService.buscarPorUsuario(request.getUsername())
				.filter(userDetails ->BCrypt.checkpw(request.getPassword(), userDetails.getPassword()))
				.map(userDetails -> ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails))))
				.switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
	}
}
