package com.reto.tecnico.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.reto.tecnico.model.dto.MonedaDto;
import com.reto.tecnico.model.entity.Moneda;

@Mapper(componentModel = "spring")
public interface MonedaMapper {

	@Mapping(source = "divisa", target = "descripcion")
	Moneda mapToMoneda (MonedaDto monedaDto);
	
	@Mapping(source = "descripcion", target = "divisa")
	MonedaDto mapToMonedaDto (Moneda moneda);
	
	
}
