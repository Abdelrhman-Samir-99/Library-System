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

import com.selfStudy.LibrarySystemBackend.exceptions.ResourceNotFoundException;
import com.selfStudy.LibrarySystemBackend.models.Employee;
import com.selfStudy.LibrarySystemBackend.repositories.EmployeeRepository;
import com.selfStudy.LibrarySystemBackend.services.implementations.EmployeeServiceImpl;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

	@InjectMocks
	EmployeeServiceImpl employeeService;

	@Mock
	EmployeeRepository employeeRepository;

	@Test
	void deleteEmployeeById_CallingDeleteEmployeeEndPointById_RemovesTheEntityIfExist() {
		// Arrange
		UUID employeeId = UUID.fromString(TestUtils.EMPLOYEE_UUID);
		Employee expectedEntity = TestUtils.createEmployeeObject();

		when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(expectedEntity));
		doNothing().when(employeeRepository).delete(expectedEntity);

		// Act
		employeeService.deleteEmployeeById(employeeId);

		// Assert
		verify(employeeRepository).findById(employeeId);
		verify(employeeRepository).delete(expectedEntity);
	}

	@Test
	void deleteIdentificationById_IdentificationDoesNotExist_ThrowsResourceNotFoundException() {
		// Arrange
		UUID employeeId = UUID.fromString(TestUtils.EMPLOYEE_UUID);

		when(employeeRepository.findById(employeeId)).thenThrow(ResourceNotFoundException.class);


		// Act - Assert
		assertThrows(ResourceNotFoundException.class, () -> {
			employeeService.deleteEmployeeById(employeeId);
		});
	}
}
