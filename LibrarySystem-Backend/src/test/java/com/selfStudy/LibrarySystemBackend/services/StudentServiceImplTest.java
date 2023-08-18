package com.selfStudy.LibrarySystemBackend.services;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.selfStudy.LibrarySystemBackend.models.Student;
import com.selfStudy.LibrarySystemBackend.repositories.StudentRepository;
import com.selfStudy.LibrarySystemBackend.services.implementations.StudentServiceImpl;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {
	@InjectMocks // TODO: figure out whether it is possible to use the abstraction instead of the concrete class, also whether I should or not.
	StudentServiceImpl studentService;

	@Mock
	StudentRepository studentRepository;

	@Test
	public void createNewIdentification_WhenCallingCorrespondingApi_ReturnsTheCreatedIdentification() {
		// Arrange
		Student expected = TestUtils.createStudentObject();

		when(studentRepository.save(expected)).thenReturn(expected);

		// Act
		Student result = studentService.createNewStudent(expected);

		// Assert
		TestUtils.compareStudentObjects(expected, result);
	}
}
