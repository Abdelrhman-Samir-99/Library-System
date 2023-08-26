package com.selfStudy.LibrarySystemBackend.controllers.implementations;

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
			throw new IllegalArgumentException(IDENTIFICATION_DTO_OBJECT_IS_MISSING);
		}

		return new ResponseEntity<>(employeeService.createNewEmployee(inputEmployee), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<EmployeeDTO> updateEmployee(EmployeeDTO inputEmployee) {
		if(inputEmployee == null) {
			throw new IllegalArgumentException(IDENTIFICATION_DTO_OBJECT_IS_MISSING);
		}

		return new ResponseEntity<>(employeeService.updateEmployee(inputEmployee), HttpStatus.OK);
	}
}
