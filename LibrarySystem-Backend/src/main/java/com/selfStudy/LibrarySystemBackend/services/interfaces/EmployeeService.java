package com.selfStudy.LibrarySystemBackend.services.interfaces;

import java.util.UUID;

import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee);

	EmployeeDTO updateEmployee(EmployeeDTO inputEmployee);

	EmployeeDTO getEmployee(UUID employeeId);
}
