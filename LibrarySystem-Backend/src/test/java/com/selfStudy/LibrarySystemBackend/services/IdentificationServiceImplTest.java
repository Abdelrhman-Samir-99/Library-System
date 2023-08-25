package com.selfStudy.LibrarySystemBackend.services;

import static org.mockito.Mockito.when;

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
	//
	// @Test
	// public void getIdentification_CallingGetIdentificationEndPointById_ReturnsTheIdentityIfExists() {
	// 	// Arrange
	// 	Identification expected = TestUtils.createIdentificationDtoObject();
	//
	//
	// 	when(identificationRepository.findById(expected.getId())).thenReturn(Optional.of(expected));
	//
	// 	// Act
	// 	IdentificationDTO result = identificationService.getIdentificationById(expected.getId());
	//
	// 	// Assert
	// 	TestUtils.compareIdentificationObjects(expected, result);
	// }
	//
	// @Test
	// public void deleteIdentification_CallingDeleteIdentificationEndPointById_ReturnsTheIdentityIfExists() {
	// 	// Arrange
	// 	Identification expected = TestUtils.createIdentificationDtoObject();
	//
	//
	// 	when(identificationRepository.findById(expected.getId())).thenReturn(Optional.of(expected));
	// 	doNothing().when(identificationRepository).delete(expected);
	//
	// 	// Act
	// 	identificationService.deleteIdentificationById(expected.getId());
	//
	// 	// Assert
	// 	verify(identificationRepository).delete(expected);
	// 	verify(identificationRepository).findById(expected.getId());
	// }
}
