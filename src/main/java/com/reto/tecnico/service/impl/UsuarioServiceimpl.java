package com.reto.tecnico.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.reto.tecnico.model.Role;
import com.reto.tecnico.repository.UsuarioRepository;
import com.reto.tecnico.security.User;
import com.reto.tecnico.service.IUsuarioService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioServiceimpl implements IUsuarioService {

	
	private final UsuarioRepository usuarioRepo;

	@Override
	public Mono<User> buscarPorUsuario(String usuario) {
		return usuarioRepo.findByUsuario(usuario)
				    .doOnNext(x-> log.info("usuarios de bd : {}", x.toString()))
					.map(u -> {
						List<Role> roles = new ArrayList<Role>();
						roles.add(u.getRol());
						 return new User(u.getUsuario(), u.getPassword(), u.getEstado(), roles);
					});
			
	}

}
