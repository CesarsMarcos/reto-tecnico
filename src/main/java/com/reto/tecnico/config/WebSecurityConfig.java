package com.reto.tecnico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.reto.tecnico.security.AuthenticationManager;
import com.reto.tecnico.security.SecurityContextRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private final AuthenticationManager authenticationManager;
	
	private final SecurityContextRepository securityContextRepository;
	
	@Bean
	public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
		return http
        .exceptionHandling()
        .authenticationEntryPoint((swe, e) -> 
            Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED))
        ).accessDeniedHandler((swe, e) -> 
            Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN))
        ).and()
        .csrf().disable()
        .formLogin().disable()
        .httpBasic().disable()
        .authenticationManager(authenticationManager)
        .securityContextRepository(securityContextRepository)
        .authorizeExchange()
        .pathMatchers(HttpMethod.OPTIONS).permitAll()		
        .pathMatchers("/v2/api-docs/**").permitAll()
		.pathMatchers("/swagger-resources/**").permitAll()
		.pathMatchers("/swagger-ui/**").permitAll()
		.pathMatchers("/webjars/**").permitAll()
        .pathMatchers("/login").permitAll()
        .anyExchange().authenticated()
        .and().build();
	}
}
