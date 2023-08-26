package com.selfStudy.LibrarySystemBackend.controllers.interfaces;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;

@RequestMapping("/api/v1/student")
public interface StudentApi {

	String STUDENT_ID_IS_NULL = "Student ID is missing!";
	String STUDENT_DTO_IS_MISSING = "Student DTO is missing!";

	@PostMapping
	ResponseEntity<StudentDTO> createNewStudent(@RequestBody StudentDTO student);

	@PutMapping
	ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO inputStudent);

	@GetMapping("/{studentId}")
	ResponseEntity<StudentDTO> getStudent(@PathVariable UUID studentId);

	@DeleteMapping("/{studentId}")
	ResponseEntity<Void> deleteStudent(@PathVariable UUID studentId);
}
