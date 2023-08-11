package com.selfStudy.LibrarySystemBackend.models;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Identification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@UuidGenerator(style = UuidGenerator.Style.TIME)
	@Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;
	private String socialNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
}
