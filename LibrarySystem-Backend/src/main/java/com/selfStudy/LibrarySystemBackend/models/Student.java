package com.selfStudy.LibrarySystemBackend.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	private UUID id;
	@ManyToOne
	private Identification identification;
	private LocalDate joinDate;
	private LocalDate graduationDate;
}
