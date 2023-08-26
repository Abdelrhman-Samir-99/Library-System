package com.selfStudy.LibrarySystemBackend.services;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.selfStudy.LibrarySystemBackend.dtos.IdentificationDTO;
import com.selfStudy.LibrarySystemBackend.mappers.IdentificationMapper;
import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.repositories.IdentificationRepository;
import com.selfStudy.LibrarySystemBackend.services.implementations.IdentificationServiceImpl;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
class IdentificationServiceImplTest {

	@InjectMocks
	IdentificationServiceImpl identificationService;

	@Mock
	IdentificationRepository identificationRepository;

	@Mock
	IdentificationMapper identificationMapper;

	@Test
	void createNewIdentification_WhenCallingCorrespondingApi_ReturnsTheCreatedIdentification() {
		// Arrange
		Identification expected = TestUtils.createIdentificationObject();
		IdentificationDTO inputIdentification = TestUtils.createIdentificationDtoObject();

		when(identificationRepository.save(expected)).thenReturn(expected);
		when(identificationMapper.mapDtoToIdentification(inputIdentification)).thenReturn(expected);
		when(identificationMapper.mapIdentificationToDto(expected)).thenReturn(inputIdentification);

		// Act
		IdentificationDTO result = identificationService.createNewIdentification(inputIdentification);

		// Assert
		TestUtils.compareIdentificationWithIdentificationDtoObjects(expected, result);
	}

	// @Test
	// public void updateIdentification_CallingUpdateIdentificationEndPointById_ReturnsTheUpdatedIdentification() {
	// 	// Arrange
	// 	IdentificationDTO expected = TestUtils.createIdentificationDtoObject();
	//
	// 	when(identificationRepository.save(expected)).thenReturn(expected);
	// 	when(identificationRepository.findById(expected.getId())).thenReturn(Optional.of(expected));
	//
	// 	// Act
	// 	IdentificationDTO result = identificationService.updateIdentification(expected);
	//
	// 	// Assert
	// 	TestUtils.compareIdentificationObjects(expected, result);
	// }

	@Test
	public void getIdentification_CallingGetIdentificationEndPointById_ReturnsTheIdentityIfExists() {
		// Arrange
		UUID identificationId = UUID.fromString(TestUtils.IDENTIFICATION_UUID);
		Identification expectedEntity = TestUtils.createIdentificationObject();
		IdentificationDTO expected = TestUtils.createIdentificationDtoObject();

		when(identificationMapper.mapIdentificationToDto(expectedEntity)).thenReturn(expected);
		when(identificationRepository.findById(identificationId)).thenReturn(Optional.of(expectedEntity));

		// Act
		IdentificationDTO result = identificationService.getIdentificationById(expected.getId());

		// Assert
		TestUtils.compareIdentificationDtoObjects(expected, result);
		verify(identificationRepository).findById(identificationId);
		verify(identificationMapper).mapIdentificationToDto(expectedEntity);
	}

	@Test
	public void deleteIdentification_CallingDeleteIdentificationEndPointById_ReturnsTheIdentityIfExists() {
		// Arrange
		UUID identificationId = UUID.fromString(TestUtils.IDENTIFICATION_UUID);
		Identification expectedEntity = TestUtils.createIdentificationObject();

		when(identificationRepository.findById(identificationId)).thenReturn(Optional.of(expectedEntity));
		doNothing().when(identificationRepository).delete(expectedEntity);

		// Act
		identificationService.deleteIdentificationById(identificationId);

		// Assert
		verify(identificationRepository).delete(expectedEntity);
		verify(identificationRepository).findById(identificationId);
	}
}
