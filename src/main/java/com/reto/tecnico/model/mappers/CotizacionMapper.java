package com.reto.tecnico.model.mappers;

import org.mapstruct.Mapper;

import com.reto.tecnico.model.dto.CotizacionDto;
import com.reto.tecnico.model.entity.Cotizacion;

@Mapper(componentModel = "spring")
public interface CotizacionMapper {
	
	CotizacionDto mapToCotizacionDto (Cotizacion cotizacion );
	
	
}
