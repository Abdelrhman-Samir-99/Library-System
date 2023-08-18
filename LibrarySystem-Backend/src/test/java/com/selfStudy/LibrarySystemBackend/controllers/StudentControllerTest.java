package com.selfStudy.LibrarySystemBackend.controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.selfStudy.LibrarySystemBackend.controllers.implementations.StudentController;
import com.selfStudy.LibrarySystemBackend.models.Student;
import com.selfStudy.LibrarySystemBackend.services.interfaces.StudentService;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
	@InjectMocks
	StudentController studentController;

	@Mock
	StudentService studentService;

	@Test
	public void createNewStudent_CorrespondingApi_ReturnsTheCreatedStudent() {
		// Arrange
		Student expected = TestUtils.createStudentObject();

		when(studentService.createNewStudent(expected)).thenReturn(expected);

		// Act
		ResponseEntity<Student> result = studentController.createNewStudent(expected);

		// Assert
		TestUtils.compareStudentObjects(expected, result.getBody());

		Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}
}
