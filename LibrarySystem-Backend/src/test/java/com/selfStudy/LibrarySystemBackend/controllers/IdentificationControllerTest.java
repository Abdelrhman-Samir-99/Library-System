package com.selfStudy.LibrarySystemBackend.controllers;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
	void createIdentification_CreatingNewIdentification_ReturnsTheCreatedIdentity() {
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
	void createNewIdentification_inputIdentificationDtoIsNull_ThrowsAnIllegalArgumentException() {
		// Arrange
		IdentificationDTO inputIdentification = null;

		// Act - Assert
		assertThrows(IllegalArgumentException.class, () -> {
			identificationController.createNewIdentification(inputIdentification);
		});
	}

	@Test
	void updateIdentification_UpdatingSpecificIdentificationById_ReturnsTheUpdatedIdentityIfExists() {
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
	void updateIdentification_inputIdentificationDtoIsNull_ThrowsAnIllegalArgumentException() {
		// Arrange
		IdentificationDTO inputIdentification = null;

		// Act - Assert
		assertThrows(IllegalArgumentException.class, () -> {
			identificationController.updateIdentification(inputIdentification);
		});
	}

	@Test
	void getIdentification_FetchingSpecificIdentificationById_ReturnsTheIdentityIfExists() {
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
	void getIdentificationById_inputIdentificationIdIsNull_ThrowsAnIllegalArgumentException() {
		// Arrange
		UUID inputIdentificationId = null;

		// Act - Assert
		assertThrows(IllegalArgumentException.class, () -> {
			identificationController.getIdentificationById(inputIdentificationId);
		});
	}

	@Test
	void deleteIdentificationById_CallingDeleteIdentificationEndPointById_DeleteTheRecordFromDatabaseIfExist() {
		// Arrange
		UUID identificationId = UUID.randomUUID();

		doNothing().when(identificationService).deleteIdentificationById(identificationId);

		// Act
		ResponseEntity<Void> result = identificationController.deleteIdentificationById(identificationId);

		// Assert
		verify(identificationService).deleteIdentificationById(identificationId);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
	}

	@Test
	void deleteIdentificationById_inputIdentificationIdIsNull_ThrowsAnIllegalArgumentException() {
		// Arrange
		UUID inputIdentificationId = null;

		// Act - Assert
		assertThrows(IllegalArgumentException.class, () -> {
			identificationController.deleteIdentificationById(inputIdentificationId);
		});
	}
}