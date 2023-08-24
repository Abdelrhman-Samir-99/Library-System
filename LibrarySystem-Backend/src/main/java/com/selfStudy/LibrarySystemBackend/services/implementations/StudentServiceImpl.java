package com.selfStudy.LibrarySystemBackend.services.implementations;

import org.springframework.stereotype.Service;

import com.selfStudy.LibrarySystemBackend.mappers.StudentMapper;
import com.selfStudy.LibrarySystemBackend.models.Student;
import com.selfStudy.LibrarySystemBackend.repositories.StudentRepository;
import com.selfStudy.LibrarySystemBackend.services.interfaces.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;
	private final StudentMapper studentMapper;

	@Override
	public Student createNewStudent(Student student) {
		return studentRepository.save(student);
	}
}
