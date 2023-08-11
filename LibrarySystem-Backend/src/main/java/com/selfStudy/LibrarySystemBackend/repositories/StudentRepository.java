package com.selfStudy.LibrarySystemBackend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selfStudy.LibrarySystemBackend.models.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}
