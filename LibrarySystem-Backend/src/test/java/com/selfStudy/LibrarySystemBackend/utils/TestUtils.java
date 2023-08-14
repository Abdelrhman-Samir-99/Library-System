package com.selfStudy.LibrarySystemBackend.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import com.selfStudy.LibrarySystemBackend.models.Identification;

public class TestUtils {
	public static void compareIdentificationObjects(Identification expected, Identification result) {
		assertEquals(result.getId(), expected.getId());
		assertEquals(result.getSocialNumber(), expected.getSocialNumber());
		assertEquals(result.getPhoneNumber(), expected.getPhoneNumber());
		assertEquals(result.getEmail(), expected.getEmail());
		assertEquals(result.getFirstName(), expected.getFirstName());
		assertEquals(result.getLastName(), expected.getLastName());
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
}
