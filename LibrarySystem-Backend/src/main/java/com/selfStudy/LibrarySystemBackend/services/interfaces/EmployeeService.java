package com.selfStudy.LibrarySystemBackend.services.interfaces;

import java.util.UUID;

import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;

public interface EmployeeService {

	String EMPLOYEE_RECORD_NOT_FOUND_WITH_ID = "Employee record not found with id: ";

	EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee);

	EmployeeDTO updateEmployee(EmployeeDTO inputEmployee);

	EmployeeDTO getEmployee(UUID employeeId);

	void deleteEmployeeById(UUID employeeId);
}
