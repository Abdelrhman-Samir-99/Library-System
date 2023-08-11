package com.selfStudy.LibrarySystemBackend.services;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.services.interfaces.IdentificationService;

public class IdentificationServiceImplTest {

	@Autowired
	IdentificationService identificationService;

	@Test
	public void createNewIndentification_WhenCallingCorrespondingApi_ReturnsTheCreatedIdentification() {
		// Arrange
		Identification expected = Identification.builder().id(UUID.fromString("77365c0c-3867-11ee-be56-0242ac120002"))
												.socialNumber("123-323-232-1231").phoneNumber("01273188179").email("testing@yopamail.com")
												.firstName("Abdelrahman").lastName("Samir").build();

		// Action
		Identification result = identificationService.createNewIdentification(expected);

		// Assert
		// hena brdo el mafrood assert equals
	}
}
