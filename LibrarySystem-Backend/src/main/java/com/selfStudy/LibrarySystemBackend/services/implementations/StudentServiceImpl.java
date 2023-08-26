package com.selfStudy.LibrarySystemBackend.services.implementations;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;
import com.selfStudy.LibrarySystemBackend.exceptions.ResourceNotFoundException;
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
	public StudentDTO createNewStudent(StudentDTO studentDto) {
		Student student = studentMapper.mapStudentDtoToStudent(studentDto);

		return studentMapper.mapStudentToStudentDto(studentRepository.save(student));
	}

	@Override
	public StudentDTO updateStudent(StudentDTO inputStudent) {
		Student existingStudent = studentRepository.findById(inputStudent.getId())
												   .orElseThrow(() -> new ResourceNotFoundException(STUDENT_NOT_FOUND_WITH_ID + inputStudent.getId()));

		Student inputStudentEntity = studentMapper.mapStudentDtoToStudent(inputStudent);

		BeanUtils.copyProperties(inputStudentEntity, existingStudent);

		existingStudent = studentRepository.save(existingStudent);


		return studentMapper.mapStudentToStudentDto(existingStudent);
	}
}
