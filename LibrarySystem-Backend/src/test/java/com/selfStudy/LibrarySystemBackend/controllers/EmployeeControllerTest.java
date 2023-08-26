package com.selfStudy.LibrarySystemBackend.controllers;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
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

import com.selfStudy.LibrarySystemBackend.controllers.implementations.EmployeeController;
import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;
import com.selfStudy.LibrarySystemBackend.services.interfaces.EmployeeService;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

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

	@Test
	void createNewEmployee_inputEmployeeDtoIsNull_ThrowsAnIllegalArgumentException() {
		// Arrange
		EmployeeDTO inputEmployee = null;

		// Act - Assert
		assertThrows(IllegalArgumentException.class, () -> {
			employeeController.createNewEmployee(inputEmployee);
		});
	}

	@Test
	void updateEmployee_UpdateExistingEmployee_ReturnsTheUpdatedEmployeeIfExist() {
		// Arrange
		EmployeeDTO inputEmployee = TestUtils.createEmployeeDtoObject();
		EmployeeDTO expected = TestUtils.createEmployeeDtoObject();

		when(employeeService.updateEmployee(inputEmployee)).thenReturn(expected);

		// Act
		ResponseEntity<EmployeeDTO> result = employeeController.updateEmployee(inputEmployee);

		// Assert
		Assertions.assertEquals(expected, result.getBody());

		Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	void updateEmployee_inputEmployeeDtoIsNull_ThrowsAnIllegalArgumentException() {
		// Arrange
		EmployeeDTO inputEmployee = null;

		// Act - Assert
		assertThrows(IllegalArgumentException.class, () -> {
			employeeController.updateEmployee(inputEmployee);
		});
	}

	@Test
	void getEmployee_UpdateExistingEmployee_ReturnsTheUpdatedEmployeeIfExist() {
		// Arrange
		UUID employeeId = UUID.fromString(TestUtils.EMPLOYEE_UUID);
		EmployeeDTO expected = TestUtils.createEmployeeDtoObject();

		when(employeeService.getEmployee(employeeId)).thenReturn(expected);

		// Act
		ResponseEntity<EmployeeDTO> result = employeeController.getEmployee(employeeId);

		// Assert
		Assertions.assertEquals(expected, result.getBody());

		Assertions.assertEquals(HttpStatus.FOUND, result.getStatusCode());
	}

	@Test
	void getEmployee_inputEmployeeDtoIsNull_ThrowsAnIllegalArgumentException() {
		// Arrange
		UUID employeeId = null;

		// Act - Assert
		assertThrows(IllegalArgumentException.class, () -> {
			employeeController.getEmployee(employeeId);
		});
	}

	@Test
	void deleteEmployee_UpdateExistingEmployee_ReturnsTheUpdatedEmployeeIfExist() {
		// Arrange
		UUID employeeId = UUID.fromString(TestUtils.EMPLOYEE_UUID);

		doNothing().when(employeeService).deleteEmployee(employeeId);

		// Act
		ResponseEntity<Void> result = employeeController.deleteEmployee(employeeId);

		// Assert

		Assertions.assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
	}

	@Test
	void deleteEmployee_inputEmployeeDtoIsNull_ThrowsAnIllegalArgumentException() {
		// Arrange
		UUID employeeId = null;

		// Act - Assert
		assertThrows(IllegalArgumentException.class, () -> {
			employeeController.deleteEmployee(employeeId);
		});
	}

}
