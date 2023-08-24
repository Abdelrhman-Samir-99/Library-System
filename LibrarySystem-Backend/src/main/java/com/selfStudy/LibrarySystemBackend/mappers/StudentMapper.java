package com.selfStudy.LibrarySystemBackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;
import com.selfStudy.LibrarySystemBackend.models.Student;

@Mapper
public interface StudentMapper extends DefaultMapper <Student, StudentDTO> {
	@Mapping(source = "identificationId", target = "identification.id")
	Student mapStudentDtoToStudent(StudentDTO studentDTO);

	@Mapping(source = "identification.id", target = "identificationId")
	StudentDTO mapStudentToStudentDto(Student student);
}
