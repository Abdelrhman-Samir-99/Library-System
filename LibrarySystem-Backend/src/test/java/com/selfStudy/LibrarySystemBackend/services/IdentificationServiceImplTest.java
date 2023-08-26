package com.selfStudy.LibrarySystemBackend.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.selfStudy.LibrarySystemBackend.exceptions.ResourceNotFoundException;
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
		verify(identificationRepository).save(expected);
		verify(identificationMapper).mapDtoToIdentification(inputIdentification);
		verify(identificationMapper).mapIdentificationToDto(expected);
	}

	@Test
	void updateIdentification_CallingUpdateIdentificationEndPointById_ReturnsTheUpdatedIdentification() {
		// Arrange
		IdentificationDTO inputIdentificationDto = TestUtils.createIdentificationDtoObject();
		Identification inputIdentificationEntity = TestUtils.createIdentificationObject();
		Identification expectedEntity = TestUtils.createIdentificationObject();
		IdentificationDTO expected = TestUtils.createIdentificationDtoObject();

		when(identificationMapper.mapDtoToIdentification(inputIdentificationDto)).thenReturn(inputIdentificationEntity);
		when(identificationRepository.findById(inputIdentificationDto.getId())).thenReturn(Optional.of(expectedEntity));
		when(identificationRepository.save(expectedEntity)).thenReturn(expectedEntity);
		when(identificationMapper.mapIdentificationToDto(expectedEntity)).thenReturn(expected);

		// Act
		IdentificationDTO result = identificationService.updateIdentification(inputIdentificationDto);

		// Assert
		TestUtils.compareIdentificationDtoObjects(expected, result);
		verify(identificationRepository).findById(inputIdentificationDto.getId());
		verify(identificationRepository).save(expectedEntity);
		verify(identificationMapper).mapDtoToIdentification(inputIdentificationDto);
		verify(identificationMapper).mapIdentificationToDto(expectedEntity);
	}

	@Test
	void updateIdentification_StudentDoesNotExist_ThrowsResourceNotFoundException() {
		// Arrange
		IdentificationDTO inputIdentification = TestUtils.createIdentificationDtoObject();

		when(identificationRepository.findById(inputIdentification.getId())).thenThrow(ResourceNotFoundException.class);


		// Act - Assert
		assertThrows(ResourceNotFoundException.class, () -> {
			identificationService.updateIdentification(inputIdentification);
		});
	}

	@Test
	void getIdentificationById_CallingGetIdentificationEndPointById_ReturnsTheIdentityIfExists() {
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
	void getIdentificationById_IdentificationDoesNotExist_ThrowsResourceNotFoundException() {
		// Arrange
		UUID identificationId = UUID.randomUUID();

		when(identificationRepository.findById(identificationId)).thenThrow(ResourceNotFoundException.class);


		// Act - Assert
		assertThrows(ResourceNotFoundException.class, () -> {
			identificationService.getIdentificationById(identificationId);
		});
	}

	@Test
	void deleteIdentificationById_CallingDeleteIdentificationEndPointById_ReturnsTheIdentityIfExists() {
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

	@Test
	void deleteIdentificationById_IdentificationDoesNotExist_ThrowsResourceNotFoundException() {
		// Arrange
		UUID identificationId = UUID.randomUUID();

		when(identificationRepository.findById(identificationId)).thenThrow(ResourceNotFoundException.class);


		// Act - Assert
		assertThrows(ResourceNotFoundException.class, () -> {
			identificationService.deleteIdentificationById(identificationId);
		});
	}
}
