package com.selfStudy.LibrarySystemBackend.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.UUID;

import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.models.Student;

public class TestUtils {
	public static void compareIdentificationObjects(Identification expected, Identification result) {
		assertEquals(expected.getId(), result.getId());
		assertEquals(expected.getSocialNumber(), result.getSocialNumber());
		assertEquals(expected.getPhoneNumber(), result.getPhoneNumber());
		assertEquals(expected.getEmail(), result.getEmail());
		assertEquals(expected.getFirstName(), result.getFirstName());
		assertEquals(expected.getLastName(), result.getLastName());
	}

	public static void compareStudentObjects(Student expected, Student result) {
		assertEquals(expected.getId(), result.getId());
		assertEquals(expected.getJoinDate(), result.getJoinDate());
		assertEquals(expected.getGraduationDate(), result.getGraduationDate());
		compareIdentificationObjects(expected.getIdentification(), result.getIdentification());
	}

	public static Identification createIdentificationObject() {
		return Identification.builder()
							 .id(UUID.fromString("77365c0c-3867-11ee-be56-0242ac120002"))
							 .socialNumber("123-323-232-1231")
							 .phoneNumber("01273188179")
							 .email("testing@yopamail.com")
							 .firstName("Abdelrahman")
							 .lastName("Samir")
							 .build();
	}

	public static Student createStudentObject() {
		LocalDate dateNow = LocalDate.now();
		Identification identification = createIdentificationObject();
		return Student.builder()
					  .id(UUID.fromString("77365c0c-3867-11ee-be56-0242ac120002"))
					  .joinDate(dateNow)
					  .graduationDate(dateNow)
					  .identification(identification)
					  .build();
	}
}
