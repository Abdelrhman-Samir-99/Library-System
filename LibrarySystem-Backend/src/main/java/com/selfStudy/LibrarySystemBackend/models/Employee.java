package com.selfStudy.LibrarySystemBackend.models;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
	@Serial
	private static final long serialVersionUID = -8996109907030861864L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@UuidGenerator(style = UuidGenerator.Style.TIME)
	@Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;
	@OneToOne
	@JoinColumn(name = "identification_id")
	private Identification identification;
	private LocalDate joinDate;
	private LocalDate leaveDate;
	private LocalDate creationDate;
	private LocalDate removeDate;
	private String profession; // consider if the relation many to many.
	private Double salary;
}
