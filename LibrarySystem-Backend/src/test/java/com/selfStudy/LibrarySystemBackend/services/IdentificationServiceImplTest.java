package com.selfStudy.LibrarySystemBackend.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.repositories.IdentificationRepository;
import com.selfStudy.LibrarySystemBackend.services.implementations.IdentificationServiceImpl;

@ExtendWith(MockitoExtension.class)
public class IdentificationServiceImplTest {

	@InjectMocks // TODO: figure out whether it is possible to use the abstraction instead of the concrete class, also whether I should or not.
	IdentificationServiceImpl identificationService;

	@Mock
	IdentificationRepository identificationRepository;

	@Test
	public void createNewIdentification_WhenCallingCorrespondingApi_ReturnsTheCreatedIdentification() {
		// Arrange
		Identification expected = Identification.builder().id(UUID.fromString("77365c0c-3867-11ee-be56-0242ac120002"))
												.socialNumber("123-323-232-1231").phoneNumber("01273188179").email("testing@yopamail.com")
												.firstName("Abdelrahman").lastName("Samir").build();

		when(identificationRepository.save(expected)).thenReturn(expected);

		// Act
		Identification result = identificationService.createNewIdentification(expected);

		// Assert
		assertEquals(result.getId(), expected.getId());
		assertEquals(result.getSocialNumber(), expected.getSocialNumber());
		assertEquals(result.getPhoneNumber(), expected.getPhoneNumber());
		assertEquals(result.getEmail(), expected.getEmail());
		assertEquals(result.getFirstName(), expected.getFirstName());
		assertEquals(result.getLastName(), expected.getLastName());
	}

	@Test
	public void updateIdentification_CallingUpdateIdentificationEndPoint_ReturnsTheUpdatedIdentification() {
		// Arrange
		Identification expected = Identification.builder().id(UUID.fromString("77365c0c-3867-11ee-be56-0242ac120002"))
												.socialNumber("123-323-232-1231").phoneNumber("01273188179").email("testing@yopamail.com")
												.firstName("Abdelrahman").lastName("Samir").build();

		when(identificationRepository.save(expected)).thenReturn(expected);
		when(identificationRepository.findById(expected.getId())).thenReturn(Optional.of(expected));

		// Act
		Identification result = identificationService.updateIdentification(expected);

		// Assert
		assertEquals(result.getId(), expected.getId());
		assertEquals(result.getSocialNumber(), expected.getSocialNumber());
		assertEquals(result.getPhoneNumber(), expected.getPhoneNumber());
		assertEquals(result.getEmail(), expected.getEmail());
		assertEquals(result.getFirstName(), expected.getFirstName());
		assertEquals(result.getLastName(), expected.getLastName());
	}

	@Test
	public void getIdentification_CallingGetIdentificationEndPoint_ReturnsTheIdentityIfExists() {
		// Arrange
		Identification expected = Identification.builder().id(UUID.fromString("77365c0c-3867-11ee-be56-0242ac120002"))
												.socialNumber("123-323-232-1231").phoneNumber("01273188179").email("testing@yopamail.com")
												.firstName("Abdelrahman").lastName("Samir").build();


		when(identificationRepository.findById(expected.getId())).thenReturn(Optional.of(expected));

		// Act
		Identification result = identificationService.getIdentification(expected.getId());

		// Assert
		assertEquals(result.getId(), expected.getId());
		assertEquals(result.getSocialNumber(), expected.getSocialNumber());
		assertEquals(result.getPhoneNumber(), expected.getPhoneNumber());
		assertEquals(result.getEmail(), expected.getEmail());
		assertEquals(result.getFirstName(), expected.getFirstName());
		assertEquals(result.getLastName(), expected.getLastName());
	}
}
