package com.selfStudy.LibrarySystemBackend.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Book {
	@Id
	private UUID id;
	private String name;
	private String description;
	private LocalDate publicationDate;
	private String author;
	@ManyToMany
	@JoinTable (
		name = "book_bookcategory_many_to_many",
		joinColumns = @JoinColumn(name = "category_id"),
		inverseJoinColumns = @JoinColumn(name = "book_id")
	)
	private Set<BookCategory> bookCategory = new HashSet<>();
}
