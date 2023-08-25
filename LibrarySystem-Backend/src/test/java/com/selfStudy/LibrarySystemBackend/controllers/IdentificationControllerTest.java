package com.selfStudy.LibrarySystemBackend.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.selfStudy.LibrarySystemBackend.controllers.implementations.IdentificationController;
import com.selfStudy.LibrarySystemBackend.dtos.IdentificationDTO;
import com.selfStudy.LibrarySystemBackend.services.interfaces.IdentificationService;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
class IdentificationControllerTest {
	@InjectMocks
	IdentificationController identificationController;

	@Mock
	IdentificationService identificationService;

	@Test
	public void createIdentification_CorrespondingApi_ReturnsTheCreatedIdentity() {
		// Arrange
		IdentificationDTO expected = TestUtils.createIdentificationDtoObject();

		when(identificationService.createNewIdentification(expected)).thenReturn(expected);

		// Act
		ResponseEntity<IdentificationDTO> result = identificationController.createNewIdentification(expected);

		// Assert
		TestUtils.compareIdentificationDtoObjects(expected, result.getBody());

		Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}

	@Test
	public void updateIdentification_CallingUpdateIdentificationEndPointById_ReturnsTheUpdatedIdentityIfExists() {
		// Arrange
		IdentificationDTO expected = TestUtils.createIdentificationDtoObject();

		when(identificationService.updateIdentification(expected)).thenReturn(expected);

		// Act
		ResponseEntity<IdentificationDTO> result = identificationController.updateIdentification(expected);

		// Assert
		TestUtils.compareIdentificationDtoObjects(expected, result.getBody());
		Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	public void getIdentification_CallingGetIdentificationEndPointById_ReturnsTheIdentityIfExists() {
		// Arrange
		IdentificationDTO expected = TestUtils.createIdentificationDtoObject();

		when(identificationService.getIdentificationById(expected.getId())).thenReturn(expected);

		// Act
		ResponseEntity<IdentificationDTO> result = identificationController.getIdentificationById(expected.getId());

		// Assert
		TestUtils.compareIdentificationDtoObjects(expected, result.getBody());
		Assertions.assertEquals(HttpStatus.FOUND, result.getStatusCode());
	}

	@Test
	public void deleteIdentification_CallingDeleteIdentificationEndPointById_DeleteTheRecordFromDatabase() {
		// Arrange
		UUID identificationId = UUID.randomUUID();

		doNothing().when(identificationService).deleteIdentificationById(identificationId);

		// Act
		ResponseEntity<Void> result = identificationController.deleteIdentificationById(identificationId);

		// Assert
		verify(identificationService).deleteIdentificationById(identificationId);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
	}
}