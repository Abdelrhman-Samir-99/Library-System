package com.selfStudy.LibrarySystemBackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;
import com.selfStudy.LibrarySystemBackend.models.Student;

@Mapper
public interface StudentMapper {
	@Mapping(source = "identificationId", target = "identification.id")
	@Mapping(source = "firstName", target = "identification.firstName")
	@Mapping(source = "lastName", target = "identification.lastName")
	Student mapStudentDtoToStudent(StudentDTO studentDTO);

	@Mapping(source = "identification.id", target = "identificationId")
	@Mapping(source = "identification.firstName", target = "firstName")
	@Mapping(source = "identification.lastName", target = "lastName")
	StudentDTO mapStudentToStudentDto(Student student);
}
