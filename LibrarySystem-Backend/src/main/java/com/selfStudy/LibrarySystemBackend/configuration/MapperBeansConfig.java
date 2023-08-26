package com.selfStudy.LibrarySystemBackend.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.selfStudy.LibrarySystemBackend.mappers.EmployeeMapper;
import com.selfStudy.LibrarySystemBackend.mappers.IdentificationMapper;
import com.selfStudy.LibrarySystemBackend.mappers.StudentMapper;

@Configuration
public class MapperBeansConfig {

	@Bean
	public StudentMapper studentMapper() {
		return Mappers.getMapper(StudentMapper.class);
	}

	@Bean
	public IdentificationMapper identificationMapper() {
		return Mappers.getMapper(IdentificationMapper.class);
	}

	@Bean
	public EmployeeMapper employeeMapper() {
		return Mappers.getMapper(EmployeeMapper.class);
	}
}
