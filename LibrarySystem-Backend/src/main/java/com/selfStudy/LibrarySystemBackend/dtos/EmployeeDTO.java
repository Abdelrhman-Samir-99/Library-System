package com.selfStudy.LibrarySystemBackend.dtos;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = { "id", "joinDate", "leaveDate", "creationDate", "removeDate", "profession", "salary", "identificationId", "lastName", "firstName" })
public class EmployeeDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1033806877267452480L;

	private UUID id;
	private String firstName;
	private String lastName;
	private LocalDate joinDate;
	private LocalDate leaveDate;
	private LocalDate creationDate;
	private LocalDate removeDate;
	private UUID identificationId;
	private String profession; // consider if the relation many to many.
	private Double salary;
}
