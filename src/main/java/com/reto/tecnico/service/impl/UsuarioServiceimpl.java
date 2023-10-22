package com.reto.tecnico.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.reto.tecnico.model.entity.Usuario;
import com.reto.tecnico.repository.IRolRepo;
import com.reto.tecnico.repository.UsuarioRepository;
import com.reto.tecnico.security.User;
import com.reto.tecnico.service.IUsuarioService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioServiceimpl implements IUsuarioService {
	
	private final UsuarioRepository usuarioRepo;
	
	private final IRolRepo rolRepo;
	
	@Override
	public Mono<Usuario> registrar(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}


	@Override
	public Mono<User> buscarPorUsuario(String usuario) {
       Mono<Usuario> monoUsuario = usuarioRepo.findOneByUsuario(usuario);
		
		List<String> roles = new ArrayList<String>();
		
		return monoUsuario.flatMap(u -> {
			
			return Flux.fromIterable(u.getRol)
					.flatMap(rol -> {
						return rolRepo.findById(rol.getId())
								.map(r -> {
									roles.add(r.getNombre());
									return r;
								});
					}).collectList().flatMap(list -> {
						u.setRoles(list);
						return Mono.just(u);
					});
		})	
		.flatMap(u -> {			
			return Mono.just(new User(u.getUsuario(), u.getPassword(), u.getEstado(), roles));
		});	
	}

	

}
