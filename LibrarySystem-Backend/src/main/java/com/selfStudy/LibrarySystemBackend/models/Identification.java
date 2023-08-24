package com.selfStudy.LibrarySystemBackend.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Entity
public class Identification implements Serializable {
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
	private LocalDate creationDate;
	private LocalDate removeDate;

	@OneToMany(mappedBy = "identification", cascade = CascadeType.REMOVE)
	Set<Employee> employeeSet = new HashSet<>();

	@OneToMany(mappedBy = "identification", cascade = CascadeType.REMOVE)
	Set<Student> studentSet = new HashSet<>();
}
