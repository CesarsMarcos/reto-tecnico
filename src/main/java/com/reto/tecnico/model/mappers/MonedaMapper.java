package com.reto.tecnico.model.mappers;

import org.mapstruct.Mapper;

import com.reto.tecnico.model.dto.MonedaDto;
import com.reto.tecnico.model.entity.Moneda;

@Mapper(componentModel = "spring")
public interface MonedaMapper {

	Moneda mapToMoneda (MonedaDto monedaDto);
	
	MonedaDto mapToMonedaDto (Moneda moneda);
	
	
}
