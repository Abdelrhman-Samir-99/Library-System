package com.selfStudy.LibrarySystemBackend.services.interfaces;

import java.util.UUID;

import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;

public interface StudentService {
	String STUDENT_NOT_FOUND_WITH_ID = "Student record not found with id: ";
	StudentDTO createNewStudent(StudentDTO student);

	StudentDTO updateStudent(StudentDTO inputStudent);

	StudentDTO getStudent(UUID studentId);

	void deleteStudent(UUID studentId);
}
