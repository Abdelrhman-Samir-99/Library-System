package com.selfStudy.LibrarySystemBackend.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	private UUID id;
	@ManyToOne
	private Identification identification;
	private LocalDate joinDate;
	private LocalDate leaveDate;
	private String profession; // consider if the relation many to many.
	private Double salary;
}
