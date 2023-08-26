package com.selfStudy.LibrarySystemBackend.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.UUID;

import com.selfStudy.LibrarySystemBackend.dtos.EmployeeDTO;
import com.selfStudy.LibrarySystemBackend.dtos.IdentificationDTO;
import com.selfStudy.LibrarySystemBackend.dtos.StudentDTO;
import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.models.Student;

public class TestUtils {

	public static final String IDENTIFICATION_UUID = "77365c0c-3867-11ee-be56-0242ac120002";
	public static final String STUDENT_UUID = "9fbe6561-586c-423a-9706-cf1989762d5a";
	public static final String EMPLOYEE_UUID = "5c525e8c-8631-40b5-b194-11a5a93b9310";

	public static void compareIdentificationWithIdentificationDtoObjects(Identification expected, IdentificationDTO result) {
		assertEquals(expected.getId(), result.getId());
		assertEquals(expected.getSocialNumber(), result.getSocialNumber());
		assertEquals(expected.getPhoneNumber(), result.getPhoneNumber());
		assertEquals(expected.getEmail(), result.getEmail());
		assertEquals(expected.getFirstName(), result.getFirstName());
		assertEquals(expected.getLastName(), result.getLastName());
	}

	public static void compareIdentificationDtoObjects(IdentificationDTO expected, IdentificationDTO result) {
		assertEquals(expected.getId(), result.getId());
		assertEquals(expected.getSocialNumber(), result.getSocialNumber());
		assertEquals(expected.getPhoneNumber(), result.getPhoneNumber());
		assertEquals(expected.getEmail(), result.getEmail());
		assertEquals(expected.getFirstName(), result.getFirstName());
		assertEquals(expected.getLastName(), result.getLastName());
	}

	public static void compareEmployeeDtoObjects(EmployeeDTO expected, EmployeeDTO result) {
		assertEquals(expected.getId(), result.getId());
		assertEquals(expected.getJoinDate(), result.getJoinDate());
		assertEquals(expected.getLeaveDate(), result.getLeaveDate());
		assertEquals(expected.getIdentificationId(), result.getIdentificationId());
	}

	public static void compareStudentDtoObjects(StudentDTO expected, StudentDTO result) {
		assertEquals(expected.getId(), result.getId());
		assertEquals(expected.getJoinDate(), result.getJoinDate());
		assertEquals(expected.getGraduationDate(), result.getGraduationDate());
		assertEquals(expected.getIdentificationId(), result.getIdentificationId());
	}

	public static IdentificationDTO createIdentificationDtoObject() {
		return IdentificationDTO.builder()
								.id(UUID.fromString(IDENTIFICATION_UUID))
								.socialNumber("123-323-232-1231")
								.phoneNumber("01273188179")
								.email("testing@yopamail.com")
								.firstName("Abdelrahman")
								.lastName("Samir")
								.build();
	}

	public static Identification createIdentificationObject() {
		return Identification.builder()
							 .id(UUID.fromString(IDENTIFICATION_UUID))
							 .socialNumber("123-323-232-1231")
							 .phoneNumber("01273188179")
							 .email("testing@yopamail.com")
							 .firstName("Abdelrahman")
							 .lastName("Samir")
							 .build();
	}

	public static Student createStudentObject() {
		LocalDate dateNow = LocalDate.now();
		Identification identification = new Identification();
		return Student.builder()
					  .id(UUID.fromString(IDENTIFICATION_UUID))
					  .joinDate(dateNow)
					  .graduationDate(dateNow)
					  .identification(identification)
					  .build();
	}

	public static StudentDTO createStudentDtoObject() {
		LocalDate dateNow = LocalDate.now();
		return StudentDTO.builder()
						 .id(UUID.fromString(STUDENT_UUID))
						 .joinDate(dateNow)
						 .graduationDate(dateNow)
						 .identificationId(UUID.fromString(IDENTIFICATION_UUID))
						 .build();
	}

	public static EmployeeDTO createEmployeeDtoObject() {
		LocalDate dateNow = LocalDate.now();
		return EmployeeDTO.builder()
						  .id(UUID.fromString(STUDENT_UUID))
						  .firstName("firstName")
						  .lastName("lastName")
						  .joinDate(dateNow)
						  .leaveDate(dateNow)
						  .creationDate(dateNow)
						  .removeDate(dateNow)
						  .identificationId(UUID.fromString(IDENTIFICATION_UUID))
						  .profession("profession")
						  .salary(1D)
						  .build();
	}

}
