package com.selfStudy.LibrarySystemBackend.services.interfaces;

import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;
import com.selfStudy.LibrarySystemBackend.models.Student;

public interface StudentService {

	StudentDTO createNewStudent(Student student);
}
