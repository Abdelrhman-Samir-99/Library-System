package com.selfStudy.LibrarySystemBackend.services.implementations;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;
import com.selfStudy.LibrarySystemBackend.exceptions.ResourceNotFoundException;
import com.selfStudy.LibrarySystemBackend.mappers.EmployeeMapper;
import com.selfStudy.LibrarySystemBackend.models.Employee;
import com.selfStudy.LibrarySystemBackend.repositories.EmployeeRepository;
import com.selfStudy.LibrarySystemBackend.services.interfaces.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final EmployeeMapper employeeMapper;

	@Override
	public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
		return null;
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO inputEmployee) {
		return null;
	}

	@Override
	public EmployeeDTO getEmployeeById(UUID employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
											  .orElseThrow(() -> new ResourceNotFoundException(EMPLOYEE_RECORD_NOT_FOUND_WITH_ID + employeeId));
		return employeeMapper.mapEmployeeToEmployeeDto(employee);
	}

	@Override
	public void deleteEmployeeById(UUID employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
											 .orElseThrow(() -> new ResourceNotFoundException(EMPLOYEE_RECORD_NOT_FOUND_WITH_ID + employeeId));

		employeeRepository.delete(employee);
	}
}