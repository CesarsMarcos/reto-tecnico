package com.reto.tecnico.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.reto.tecnico.model.entity.Moneda;

public interface MonedaRepository extends ReactiveCrudRepository<Moneda, Long>{

}
