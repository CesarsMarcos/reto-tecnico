package com.reto.tecnico.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;

import reactor.core.publisher.Mono;

@Component
@Order(-1)
public class GlobalWebExceptionHandler2   implements WebExceptionHandler {


	@Override
	public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
		if (ex instanceof ErrorNotFoundException) {
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);

            return exchange.getResponse().setComplete();
        }
        return Mono.error(ex);
	}
}
