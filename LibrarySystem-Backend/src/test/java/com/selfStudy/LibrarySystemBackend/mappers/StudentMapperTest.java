package com.selfStudy.LibrarySystemBackend.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;
import com.selfStudy.LibrarySystemBackend.models.Student;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

class StudentMapperTest {
	private StudentMapper studentMapper;

	@BeforeEach
	public void setUp() {
		studentMapper = Mappers.getMapper(StudentMapper.class);
	}

	@Test
	void testMapDtoToIdentification() {
		// Arrange
		StudentDTO studentDTO = TestUtils.createStudentDtoObject();

		// Act
		Student student = studentMapper.mapStudentDtoToStudent(studentDTO);

		// Assert
		TestUtils.compareStudentWithStudentDtoObject(student, studentDTO);
	}

	@Test
	void testMapIdentificationToDto() {
		// Arrange
		Student student = TestUtils.createStudentObject();

		// Act
		StudentDTO studentDTO = studentMapper.mapStudentToStudentDto(student);

		// Assert
		TestUtils.compareStudentWithStudentDtoObject(student, studentDTO);
	}
}
