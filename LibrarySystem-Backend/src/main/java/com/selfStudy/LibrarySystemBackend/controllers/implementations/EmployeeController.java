package com.selfStudy.LibrarySystemBackend.controllers.implementations;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.selfStudy.LibrarySystemBackend.controllers.interfaces.EmployeeApi;
import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;
import com.selfStudy.LibrarySystemBackend.services.interfaces.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController implements EmployeeApi {

	private final EmployeeService employeeService;

	@Override
	public ResponseEntity<EmployeeDTO> createNewEmployee(EmployeeDTO inputEmployee) {
		if(inputEmployee == null) {
			throw new IllegalArgumentException(EMPLOYEE_DTO_OBJECT_IS_MISSING);
		}

		return new ResponseEntity<>(employeeService.createNewEmployee(inputEmployee), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<EmployeeDTO> updateEmployee(EmployeeDTO inputEmployee) {
		if(inputEmployee == null) {
			throw new IllegalArgumentException(EMPLOYEE_DTO_OBJECT_IS_MISSING);
		}

		return new ResponseEntity<>(employeeService.updateEmployee(inputEmployee), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EmployeeDTO> getEmployee(UUID employeeId) {
		if(employeeId == null) {
			throw new IllegalArgumentException(EMPLOYEE_ID_IS_MISSING);
		}

		return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Void> deleteEmployee(UUID employeeId) {
		if(employeeId == null) {
			throw new IllegalArgumentException(EMPLOYEE_ID_IS_MISSING);
		}

		employeeService.deleteEmployeeById(employeeId);

		return ResponseEntity.noContent().build();
	}
}
