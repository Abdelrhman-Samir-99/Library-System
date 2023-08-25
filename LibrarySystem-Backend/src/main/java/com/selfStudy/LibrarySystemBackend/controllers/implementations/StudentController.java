package com.selfStudy.LibrarySystemBackend.controllers.implementations;

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
			throw new IllegalArgumentException("Identification ID is null");
		}

		return new ResponseEntity<>(studentService.createNewStudent(student), HttpStatus.CREATED);
	}
}
