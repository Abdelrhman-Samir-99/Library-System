package com.selfStudy.LibrarySystemBackend.controllers.interfaces;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;

@RequestMapping("/api/v1/employee")
public interface EmployeeApi {

	String EMPLOYEE_DTO_OBJECT_IS_MISSING = "Employee DTO Object is missing!";
	String EMPLOYEE_ID_IS_MISSING = "Employee ID is missing!";

	@PostMapping
	ResponseEntity<EmployeeDTO> createNewEmployee(EmployeeDTO inputEmployee);

	@PutMapping
	ResponseEntity<EmployeeDTO> updateEmployee(EmployeeDTO inputEmployee);

	@GetMapping
	ResponseEntity<EmployeeDTO> getEmployee(UUID employeeId);

	@DeleteMapping
	ResponseEntity<Void> deleteEmployee(UUID employeeId);
}
