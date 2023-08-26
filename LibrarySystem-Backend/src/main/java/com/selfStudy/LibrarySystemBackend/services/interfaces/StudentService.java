package com.selfStudy.LibrarySystemBackend.services.interfaces;

import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;

public interface StudentService {
	String STUDENT_NOT_FOUND_WITH_ID = "Student not found with id: ";
	StudentDTO createNewStudent(StudentDTO student);

	StudentDTO updateStudent(StudentDTO inputStudent);
}
