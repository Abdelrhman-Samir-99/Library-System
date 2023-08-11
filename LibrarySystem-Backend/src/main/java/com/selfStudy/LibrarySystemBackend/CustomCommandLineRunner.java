package com.selfStudy.LibrarySystemBackend;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.selfStudy.LibrarySystemBackend.models.Book;
import com.selfStudy.LibrarySystemBackend.models.BookCategory;
import com.selfStudy.LibrarySystemBackend.models.Employee;
import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.models.Student;
import com.selfStudy.LibrarySystemBackend.repositories.BookCategoryRepository;
import com.selfStudy.LibrarySystemBackend.repositories.BookRepository;
import com.selfStudy.LibrarySystemBackend.repositories.EmployeeRepository;
import com.selfStudy.LibrarySystemBackend.repositories.IdentificationRepository;
import com.selfStudy.LibrarySystemBackend.repositories.StudentRepository;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

	BookCategoryRepository bookCategoryRepository;

	BookRepository bookRepository;

	IdentificationRepository identificationRepository;

	StudentRepository studentRepository;

	EmployeeRepository employeeRepository;

	@Autowired
	public CustomCommandLineRunner(BookCategoryRepository bookCategoryRepository, BookRepository bookRepository,
			IdentificationRepository identificationRepository, StudentRepository studentRepository,
			EmployeeRepository employeeRepository) {
		this.bookCategoryRepository = bookCategoryRepository;
		this.bookRepository = bookRepository;
		this.identificationRepository = identificationRepository;
		this.studentRepository = studentRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Identification identificationSamir = Identification.builder().email("abdulrhman.samir123@gmail.com")
														   .firstName("Abdelrahman").lastName("Samir").address("Egypt").phoneNumber("01273188179")
														   .socialNumber("ASJDOJASODJOASDJ").build();
		identificationSamir = identificationRepository.save(identificationSamir);

		LocalDate currentLocalDate = LocalDate.now();
		Student student = Student.builder().graduationDate(currentLocalDate).joinDate(currentLocalDate).build();
		student = studentRepository.save(student);


		Employee employee = Employee.builder().joinDate(currentLocalDate).leaveDate(currentLocalDate)
									.salary(16500.50d).identification(identificationSamir).profession("Developer").build();
		employee = employeeRepository.save(employee);


		BookCategory bookCategory = BookCategory.builder().category("Educational").description("Teaching others how to do something").build();

		Book book = Book.builder().author("Abdelrhman").name("How to get better at league").description("Book that especially made for Telmeez Samir").bookCategory(null).build();
	}
}
