package com.selfStudy.LibrarySystemBackend.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.selfStudy.LibrarySystemBackend.dtos.IdentificationDTO;
import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

class IdentificationMapperTest {

	private IdentificationMapper identificationMapper;

	@BeforeEach
	public void setUp() {
		identificationMapper = Mappers.getMapper(IdentificationMapper.class);
	}

	@Test
	void testMapDtoToIdentification() {
		// Arrange
		IdentificationDTO identificationDTO = TestUtils.createIdentificationDtoObject();

		// Act
		Identification identification = identificationMapper.mapDtoToIdentification(identificationDTO);

		// Assert
		TestUtils.compareIdentificationWithIdentificationDtoObjects(identification, identificationDTO);
	}

	@Test
	void testMapIdentificationToDto() {
		// Arrange
		Identification identification = TestUtils.createIdentificationObject();

		// Act
		IdentificationDTO identificationDTO = identificationMapper.mapIdentificationToDto(identification);

		// Assert
		TestUtils.compareIdentificationWithIdentificationDtoObjects(identification, identificationDTO);
	}
}