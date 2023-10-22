package com.reto.tecnico.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.tecnico.model.entity.Usuario;
import com.reto.tecnico.model.request.AutenticacionRequest;
import com.reto.tecnico.model.response.AuthResponse;
import com.reto.tecnico.security.ErrorLogin;
import com.reto.tecnico.security.JwtService;
import com.reto.tecnico.service.IUsuarioService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("auth/")
@RequiredArgsConstructor
public class AutenticacionController {

	private JwtService jwtUtil;

	private IUsuarioService usuarioService;

	@PostMapping("login")
	public Mono<ResponseEntity<?>> login(@RequestBody AutenticacionRequest request) {
		return usuarioService.buscarPorUsuario(request.getUsername()).map((userDetails) -> {

			if (BCrypt.checkpw(request.getPassword(), userDetails.getPassword())) {
				String token = jwtUtil.generateToken(userDetails);
				Date expiracion = jwtUtil.getExpirationDateFromToken(token);

				return ResponseEntity.ok(new AuthResponse(token, expiracion));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
						.body(new ErrorLogin("credenciales incorrectas", new Date()));
			}
		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	
	@PostMapping("registro")
	public Mono<Usuario> registrar(@RequestBody Usuario usuario){
		return usuarioService.registrar(usuario);

	}

}
