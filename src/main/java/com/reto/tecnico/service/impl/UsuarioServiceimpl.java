package com.reto.tecnico.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.reto.tecnico.model.Role;
import com.reto.tecnico.model.entity.Usuario;
import com.reto.tecnico.repository.UsuarioRepository;
import com.reto.tecnico.security.User;
import com.reto.tecnico.service.IUsuarioService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioServiceimpl implements IUsuarioService {

	
	private final UsuarioRepository usuarioRepo;

	@Override
	public Mono<User> buscarPorUsuario(String usuario) {
		Mono<Usuario> monoUsuario = usuarioRepo.findOneByUsuario(usuario);
		
		return monoUsuario.flatMap(
				user-> {
					List<Role> roles = new ArrayList<Role>();
					roles.add(user.getRol());
			     return Mono.just(new User(user.getUsuario(), user.getPassword(), user.getEstado(), roles));
			});
	}

}
