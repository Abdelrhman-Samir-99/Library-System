package com.selfStudy.LibrarySystemBackend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selfStudy.LibrarySystemBackend.models.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, UUID> {

}
