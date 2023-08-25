package com.selfStudy.LibrarySystemBackend.dtos;

import java.io.Serial;
import java.io.Serializable;
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
public class IdentificationDTO implements Serializable {
	@Serial
	private static final long serialVersionUID = 8874916258944243041L;

	private UUID id;
	private String socialNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
}
