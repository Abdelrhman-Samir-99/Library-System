package com.selfStudy.LibrarySystemBackend.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.selfStudy.LibrarySystemBackend.models.Student;

@RequestMapping("/api/v1/student")
public interface StudentApi {
	@PostMapping
	ResponseEntity<Student> createNewStudent(@RequestBody Student student);
}
