package com.selfStudy.LibrarySystemBackend.mappers;

import org.mapstruct.Mapper;

import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;
import com.selfStudy.LibrarySystemBackend.models.Employee;

@Mapper
public interface EmployeeMapper {

	EmployeeDTO mapEmployeeToEmployeeDto(Employee employee);
}
