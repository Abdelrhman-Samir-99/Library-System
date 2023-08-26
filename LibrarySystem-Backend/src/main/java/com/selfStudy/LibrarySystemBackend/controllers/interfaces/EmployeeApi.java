package com.selfStudy.LibrarySystemBackend.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;

@RequestMapping("/api/v1/employee")
public interface EmployeeApi {

	ResponseEntity<EmployeeDTO> createNewEmployee(EmployeeDTO inputEmployee);
}
