package com.selfStudy.LibrarySystemBackend.services;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.repositories.IdentificationRepository;
import com.selfStudy.LibrarySystemBackend.services.implementations.IdentificationServiceImpl;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
public class IdentificationServiceImplTest {

	@InjectMocks // TODO: figure out whether it is possible to use the abstraction instead of the concrete class, also whether I should or not.
	IdentificationServiceImpl identificationService;

	@Mock
	IdentificationRepository identificationRepository;

	@Test
	public void createNewIdentification_WhenCallingCorrespondingApi_ReturnsTheCreatedIdentification() {
		// Arrange
		Identification expected = TestUtils.createIdentificationObject();

		when(identificationRepository.save(expected)).thenReturn(expected);

		// Act
		Identification result = identificationService.createNewIdentification(expected);

		// Assert
		TestUtils.compareIdentificationObjects(expected, result);
	}

	@Test
	public void updateIdentification_CallingUpdateIdentificationEndPoint_ReturnsTheUpdatedIdentification() {
		// Arrange
		Identification expected = TestUtils.createIdentificationObject();

		when(identificationRepository.save(expected)).thenReturn(expected);
		when(identificationRepository.findById(expected.getId())).thenReturn(Optional.of(expected));

		// Act
		Identification result = identificationService.updateIdentification(expected);

		// Assert
		TestUtils.compareIdentificationObjects(expected, result);
	}

	@Test
	public void getIdentification_CallingGetIdentificationEndPoint_ReturnsTheIdentityIfExists() {
		// Arrange
		Identification expected = TestUtils.createIdentificationObject();


		when(identificationRepository.findById(expected.getId())).thenReturn(Optional.of(expected));

		// Act
		Identification result = identificationService.getIdentification(expected.getId());

		// Assert
		TestUtils.compareIdentificationObjects(expected, result);
	}
}
