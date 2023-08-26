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
		return new ResponseEntity<>(employeeService.createNewEmployee(inputEmployee), HttpStatus.CREATED);
	}
}
