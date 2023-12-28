package com.reto.tecnico.model.mappers;

import org.mapstruct.Mapper;

import com.reto.tecnico.model.dto.TipoCambioDto;
import com.reto.tecnico.model.entity.TipoCambio;

@Mapper(componentModel = "spring")
public interface TipoCambioMapper {
	
	
	TipoCambio mapTipoCambio (TipoCambioDto cambioDto);
	
	TipoCambioDto mapTipoCambioDto (TipoCambio cambio);
	
}
