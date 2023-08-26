package com.selfStudy.LibrarySystemBackend.services.interfaces;

import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee);
}
