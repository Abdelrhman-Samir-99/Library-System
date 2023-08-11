package com.selfStudy.LibrarySystemBackend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selfStudy.LibrarySystemBackend.models.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {

}
