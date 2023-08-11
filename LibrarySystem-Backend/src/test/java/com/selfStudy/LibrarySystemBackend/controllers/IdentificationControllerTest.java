package com.selfStudy.LibrarySystemBackend.controllers;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.selfStudy.LibrarySystemBackend.controllers.implementations.IdentificationController;
import com.selfStudy.LibrarySystemBackend.models.Identification;

class IdentificationControllerTest {
	@Autowired
	IdentificationController identificationController;

	@Test
	public void createIdentification_CorrespondingApi_ReturnsTheCreatedIdentity() {
		// Arrange
		Identification expected = Identification.builder().id(UUID.fromString("77365c0c-3867-11ee-be56-0242ac120002"))
												.socialNumber("123-323-232-1231").phoneNumber("01273188179").email("testing@yopamail.com")
												.firstName("Abdelrahman").lastName("Samir").build();

		// Action
		Identification result = identificationController.createNewIdentification(expected);

		// Assert
		// el mafrood en hena Assert.assertEquals(result, expected);
	}
}