package com.selfStudy.LibrarySystemBackend.services.interfaces;

import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;

public interface StudentService {

	StudentDTO createNewStudent(StudentDTO student);

	StudentDTO updateStudent(StudentDTO inputStudent);
}
