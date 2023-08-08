package com.selfStudy.LibrarySystemBackend.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class BookCategory {
	@Id
	private UUID id;
	private String category;
	private String description;
	@ManyToMany(mappedBy = "bookCategory")
	private Set<Book> bookList = new HashSet<>();
}
