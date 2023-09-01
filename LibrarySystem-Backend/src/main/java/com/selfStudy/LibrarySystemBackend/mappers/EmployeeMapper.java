package com.selfStudy.LibrarySystemBackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;
import com.selfStudy.LibrarySystemBackend.models.Employee;

@Mapper
public interface EmployeeMapper {

	@Mapping(source = "identification.id", target = "identificationId")
	@Mapping(source = "identification.firstName", target = "firstName")
	@Mapping(source = "identification.lastName", target = "lastName")
	EmployeeDTO mapEmployeeToEmployeeDto(Employee employee);

	@Mapping(source = "identificationId", target = "identification.id")
	@Mapping(source = "firstName", target = "identification.firstName")
	@Mapping(source = "lastName", target = "identification.lastName")
	Employee mapEmployeeDtoToEmployee(EmployeeDTO employeeDto);
}
