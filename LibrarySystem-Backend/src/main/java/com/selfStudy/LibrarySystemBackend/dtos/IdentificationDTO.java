package com.selfStudy.LibrarySystemBackend.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class IdentificationDTO {
	private UUID id;
	private String socialNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
}
