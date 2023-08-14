package com.selfStudy.LibrarySystemBackend.controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.selfStudy.LibrarySystemBackend.controllers.implementations.IdentificationController;
import com.selfStudy.LibrarySystemBackend.models.Identification;
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
		Identification expected = TestUtils.createIdentificationObject();

		when(identificationService.createNewIdentification(expected)).thenReturn(expected);

		// Act
		Identification result = identificationController.createNewIdentification(expected);

		// Assert
		TestUtils.compareIdentificationObjects(expected, result);
	}

	@Test
	public void updateIdentification_CallingUpdateIdentificationEndPoint_ReturnsTheUpdatedIdentityIfExists() {
		// Arrange
		Identification expected = TestUtils.createIdentificationObject();

		when(identificationService.updateIdentification(expected)).thenReturn(expected);

		// Act
		Identification result = identificationController.updateIdentification(expected);

		// Assert
		TestUtils.compareIdentificationObjects(expected, result);
	}

	@Test
	public void getIdentification_CallingGetIdentificationEndPoint_ReturnsTheIdentityIfExists() {
		// Arrange
		Identification expected = TestUtils.createIdentificationObject();

		when(identificationService.getIdentification(expected.getId())).thenReturn(expected);

		// Act
		Identification result = identificationController.getIdentification(expected.getId());

		// Assert
		TestUtils.compareIdentificationObjects(expected, result);
	}
}