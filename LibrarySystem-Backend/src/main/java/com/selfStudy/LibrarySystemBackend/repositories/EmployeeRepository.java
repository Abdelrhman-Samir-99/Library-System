package com.selfStudy.LibrarySystemBackend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selfStudy.LibrarySystemBackend.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
