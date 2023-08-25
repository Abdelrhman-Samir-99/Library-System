package com.selfStudy.LibrarySystemBackend.services;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;
import com.selfStudy.LibrarySystemBackend.mappers.StudentMapper;
import com.selfStudy.LibrarySystemBackend.models.Student;
import com.selfStudy.LibrarySystemBackend.repositories.StudentRepository;
import com.selfStudy.LibrarySystemBackend.services.implementations.StudentServiceImpl;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
	@InjectMocks // TODO: figure out whether it is possible to use the abstraction instead of the concrete class, also whether I should or not.
	StudentServiceImpl studentService;

	@Mock
	StudentRepository studentRepository;

	@Mock
	StudentMapper studentMapper;

	@Test
	 void createNewIdentification_WhenCallingCorrespondingApi_ReturnsTheCreatedIdentification() {
		// Arrange
		StudentDTO inputStudent = TestUtils.createStudentDtoObject();
		Student student = TestUtils.createStudentObject();
		StudentDTO expectedDTO = TestUtils.createStudentDtoObject();

		when(studentMapper.mapStudentDtoToStudent(inputStudent)).thenReturn(student);
		when(studentRepository.save(student)).thenReturn(student);
		when(studentMapper.mapStudentToStudentDto(student)).thenReturn(expectedDTO);

		// Act
		StudentDTO result = studentService.createNewStudent(inputStudent);

		// Assert
		TestUtils.compareStudentDtoObjects(expectedDTO, result);
		verify(studentMapper).mapStudentDtoToStudent(inputStudent);
		verify(studentRepository).save(student);
		verify(studentMapper).mapStudentToStudentDto(student);
	}
}
