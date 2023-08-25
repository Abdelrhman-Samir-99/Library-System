package com.selfStudy.LibrarySystemBackend.dtos;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
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
public class StudentDTO implements Serializable {
	@Serial
	private static final long serialVersionUID = 1251369952720664243L;

	private UUID id;
	private String firstName;
	private String lastName;
	private LocalDate joinDate;
	private LocalDate graduationDate;
	private LocalDate creationDate;
	private LocalDate removeDate;
	private UUID identificationId;
}
