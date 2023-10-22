package com.reto.tecnico.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.reto.tecnico.model.Rol;



public interface IRolRepo extends ReactiveCrudRepository<Rol, String>{

}
