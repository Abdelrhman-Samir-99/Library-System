package com.selfStudy.LibrarySystemBackend.services.implementations;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;
import com.selfStudy.LibrarySystemBackend.repositories.EmployeeRepository;
import com.selfStudy.LibrarySystemBackend.services.interfaces.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
		return null;
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO inputEmployee) {
		return null;
	}

	@Override
	public EmployeeDTO getEmployee(UUID employeeId) {
		return null;
	}

	@Override
	public void deleteEmployee(UUID employeeId) {

	}
}
