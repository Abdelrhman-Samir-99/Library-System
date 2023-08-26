package com.selfStudy.LibrarySystemBackend.controllers.implementations;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.selfStudy.LibrarySystemBackend.controllers.interfaces.StudentApi;
import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;
import com.selfStudy.LibrarySystemBackend.services.interfaces.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentApi {

	private final StudentService studentService;

	@Override
	public ResponseEntity<StudentDTO> createNewStudent(StudentDTO student) {
		if(student == null) {
			throw new IllegalArgumentException("Student DTO is missing!");
		}

		return new ResponseEntity<>(studentService.createNewStudent(student), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<StudentDTO> updateStudent(StudentDTO inputStudent) {
		if(inputStudent == null) {
			throw new IllegalArgumentException(STUDENT_DTO_IS_MISSING);
		}

		return new ResponseEntity<>(studentService.updateStudent(inputStudent), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StudentDTO> getStudent(UUID studentId) {
		if(studentId == null) {
			throw new IllegalArgumentException(STUDENT_ID_IS_NULL);
		}

		return new ResponseEntity<>(studentService.getStudent(studentId), HttpStatus.FOUND);
	}
}
