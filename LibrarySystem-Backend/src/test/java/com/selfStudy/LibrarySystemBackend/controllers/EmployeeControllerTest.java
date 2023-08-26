package com.selfStudy.LibrarySystemBackend.controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.selfStudy.LibrarySystemBackend.controllers.implementations.EmployeeController;
import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;
import com.selfStudy.LibrarySystemBackend.services.interfaces.EmployeeService;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	private EmployeeService employeeService;

	@Test
	void createNewEmployee_CreatingNewEmployee_ReturnsTheCreatedEmployee() {
		// Arrange
		EmployeeDTO inputEmployee = TestUtils.createEmployeeDtoObject();
		EmployeeDTO expected = TestUtils.createEmployeeDtoObject();

		when(employeeService.createNewEmployee(inputEmployee)).thenReturn(expected);

		// Act
		ResponseEntity<EmployeeDTO> result = employeeController.createNewEmployee(inputEmployee);

		// Assert
		Assertions.assertEquals(expected, result.getBody());

		Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}

}
