package com.selfStudy.LibrarySystemBackend.services;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

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

	@InjectMocks
	StudentServiceImpl studentService;

	@Mock
	StudentRepository studentRepository;

	@Mock
	StudentMapper studentMapper;

	@Test
	void createNewStudent_CreatingNewStudent_ReturnsTheCreatedStudent() {
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

	@Test
	void updateStudent_UpdatingExistingStudent_ReturnsTheUpdatedStudent() {
		// Arrange
		StudentDTO inputStudent = TestUtils.createStudentDtoObject();
		StudentDTO expected = TestUtils.createStudentDtoObject();

		Student inputEntity = TestUtils.createStudentObject();
		Student expectedEntity = TestUtils.createStudentObject();

		when(studentRepository.save(inputEntity)).thenReturn(expectedEntity);
		when(studentRepository.findById(inputStudent.getId())).thenReturn(Optional.of(inputEntity));
		when(studentMapper.mapStudentDtoToStudent(inputStudent)).thenReturn(expectedEntity);
		when(studentMapper.mapStudentToStudentDto(expectedEntity)).thenReturn(expected);

		// Act
		StudentDTO result = studentService.updateStudent(inputStudent);

		// Assert
		TestUtils.compareStudentDtoObjects(expected, result);
		verify(studentMapper).mapStudentDtoToStudent(inputStudent);
		verify(studentRepository).save(inputEntity);
		verify(studentRepository).findById(inputStudent.getId());
		verify(studentMapper).mapStudentToStudentDto(expectedEntity);
	}

	@Test
	void getStudent_FetchingTheStudentById_ReturnsTheSpecifiedStudentIfExist() {
		// Arrange
		UUID studentId = UUID.fromString(TestUtils.STUDENT_UUID);
		StudentDTO expected = TestUtils.createStudentDtoObject();
		Student expectedEntity = TestUtils.createStudentObject();

		when(studentRepository.findById(studentId)).thenReturn(Optional.of(expectedEntity));
		when(studentMapper.mapStudentToStudentDto(expectedEntity)).thenReturn(expected);

		// Act
		StudentDTO result = studentService.getStudent(studentId);

		// Assert
		TestUtils.compareStudentDtoObjects(expected, result);
		verify(studentRepository).findById(studentId);
		verify(studentMapper).mapStudentToStudentDto(expectedEntity);
	}

	@Test
	void deleteStudent_FetchingTheStudentById_ReturnsTheSpecifiedStudentIfExist() {
		// Arrange
		UUID studentId = UUID.fromString(TestUtils.STUDENT_UUID);
		Student expectedEntity = TestUtils.createStudentObject();

		when(studentRepository.findById(studentId)).thenReturn(Optional.of(expectedEntity));
		doNothing().when(studentRepository).delete(expectedEntity);

		// Act
		studentService.deleteStudent(studentId);

		// Assert
		verify(studentRepository).findById(studentId);
		verify(studentRepository).delete(expectedEntity);
	}
}
