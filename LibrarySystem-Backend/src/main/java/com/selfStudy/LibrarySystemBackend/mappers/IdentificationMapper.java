package com.selfStudy.LibrarySystemBackend.mappers;

import org.mapstruct.Mapper;

import com.selfStudy.LibrarySystemBackend.dtos.IdentificationDTO;
import com.selfStudy.LibrarySystemBackend.models.Identification;

@Mapper
public interface IdentificationMapper {
	Identification mapDtoToIdentification(IdentificationDTO identificationDTO);
	IdentificationDTO mapIdentificationToDto(Identification identification);
}
