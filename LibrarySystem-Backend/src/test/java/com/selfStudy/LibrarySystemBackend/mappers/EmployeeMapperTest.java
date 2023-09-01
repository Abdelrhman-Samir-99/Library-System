package com.selfStudy.LibrarySystemBackend.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;
import com.selfStudy.LibrarySystemBackend.models.Employee;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

public class EmployeeMapperTest {

	private EmployeeMapper employeeMapper;

	@BeforeEach
	public void setUp() {
		employeeMapper = Mappers.getMapper(EmployeeMapper.class);
	}

	@Test
	void testMapDtoToIdentification() {
		// Arrange
		EmployeeDTO employeeDTO = TestUtils.createEmployeeDtoObject();

		// Act
		Employee employee = employeeMapper.mapEmployeeDtoToEmployee(employeeDTO);

		// Assert
		TestUtils.compareEmployeeWithEmployeeDtoObject(employee, employeeDTO);
	}

	@Test
	void testMapIdentificationToDto() {
		// Arrange
		Employee employee = TestUtils.createEmployeeObject();

		// Act
		EmployeeDTO employeeDTO = employeeMapper.mapEmployeeToEmployeeDto(employee);

		// Assert
		TestUtils.compareEmployeeWithEmployeeDtoObject(employee, employeeDTO);
	}
}
