package com.selfStudy.LibrarySystemBackend.controllers;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.selfStudy.LibrarySystemBackend.controllers.implementations.StudentController;
import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;
import com.selfStudy.LibrarySystemBackend.services.interfaces.StudentService;
import com.selfStudy.LibrarySystemBackend.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

	@InjectMocks
	StudentController studentController;

	@Mock
	StudentService studentService;

	@Test
	void createNewStudent_CreatingNewStudent_ReturnsTheCreatedStudent() {
		// Arrange
		StudentDTO expected = TestUtils.createStudentDtoObject();

		when(studentService.createNewStudent(expected)).thenReturn(expected);

		// Act
		ResponseEntity<StudentDTO> result = studentController.createNewStudent(expected);

		// Assert
		TestUtils.compareStudentDtoObjects(expected, result.getBody());

		Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}

	@Test
	void createNewStudent_inputStudentDtoIsNull_ThrowsAnIllegalArgumentException() {
		// Arrange
		StudentDTO inputStudent = null;

		// Act - Assert
		assertThrows(IllegalArgumentException.class, () -> {
			studentController.createNewStudent(inputStudent);
		});
	}

	@Test
	void updateStudent_UpdatingExistingStudent_ReturnsTheUpdatedStudent() {
		// Arrange
		StudentDTO inputStudent = TestUtils.createStudentDtoObject();
		StudentDTO expected = TestUtils.createStudentDtoObject();

		when(studentService.updateStudent(inputStudent)).thenReturn(expected);

		// Act
		ResponseEntity<StudentDTO> result = studentController.updateStudent(inputStudent);

		// Assert
		TestUtils.compareStudentDtoObjects(expected, result.getBody());

		Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	void updateStudent_inputStudentDtoIsNull_ThrowsAnIllegalArgumentException() {
		// Arrange
		StudentDTO inputStudent = null;

		// Act - Assert
		assertThrows(IllegalArgumentException.class, () -> {
			studentController.updateStudent(inputStudent);
		});
	}

	@Test
	void getStudent_FetchingSpecificStudentById_ReturnsTheSpecifiedStudent() {
		// Arrange
		UUID studentId = UUID.fromString(TestUtils.STUDENT_UUID);
		StudentDTO expected = TestUtils.createStudentDtoObject();

		when(studentService.getStudent(studentId)).thenReturn(expected);

		// Act
		ResponseEntity<StudentDTO> result = studentController.getStudent(studentId);

		// Assert
		TestUtils.compareStudentDtoObjects(expected, result.getBody());

		Assertions.assertEquals(HttpStatus.FOUND, result.getStatusCode());
	}

	@Test
	void getStudent_inputStudentIdIsNull_ThrowsAnIllegalArgumentException() {
		// Arrange
		UUID studentId = null;

		// Act - Assert
		assertThrows(IllegalArgumentException.class, () -> {
			studentController.getStudent(studentId);
		});
	}

	@Test
	void deleteStudent_deleteSpecificStudentById_DeleteTheRecordFromDatabase() {
		// Arrange
		UUID studentId = UUID.fromString(TestUtils.STUDENT_UUID);

		doNothing().when(studentService).deleteStudent(studentId);

		// Act
		ResponseEntity<Void> result = studentController.deleteStudent(studentId);

		// Assert
		verify(studentService).deleteStudent(studentId);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
	}

	@Test
	void deleteStudent_inputStudentIdIsNull_ThrowsAnIllegalArgumentException() {
		// Arrange
		UUID studentId = null;

		// Act - Assert
		assertThrows(IllegalArgumentException.class, () -> {
			studentController.deleteStudent(studentId);
		});
	}
}
