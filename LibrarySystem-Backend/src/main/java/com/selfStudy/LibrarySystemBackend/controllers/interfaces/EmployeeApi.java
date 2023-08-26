package com.selfStudy.LibrarySystemBackend.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;

@RequestMapping("/api/v1/employee")
public interface EmployeeApi {

	String IDENTIFICATION_DTO_OBJECT_IS_MISSING = "Identification DTO Object is missing!";

	@GetMapping
	ResponseEntity<EmployeeDTO> createNewEmployee(EmployeeDTO inputEmployee);
}
