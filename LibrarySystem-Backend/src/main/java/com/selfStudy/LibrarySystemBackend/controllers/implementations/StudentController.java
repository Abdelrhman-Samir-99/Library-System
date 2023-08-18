package com.selfStudy.LibrarySystemBackend.controllers.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.selfStudy.LibrarySystemBackend.controllers.interfaces.StudentApi;
import com.selfStudy.LibrarySystemBackend.models.Student;
import com.selfStudy.LibrarySystemBackend.services.interfaces.StudentService;

@RestController
public class StudentController implements StudentApi {

	StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public ResponseEntity<Student> createNewStudent(Student student) {
		if(student == null) {
			throw new IllegalArgumentException("Identification ID is null");
		}

		return new ResponseEntity<>(studentService.createNewStudent(student), HttpStatus.CREATED);
	}
}
