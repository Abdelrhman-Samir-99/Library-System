package com.selfStudy.LibrarySystemBackend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.selfStudy.LibrarySystemBackend.models.Identification;

public interface IdentificationRepository extends JpaRepository<Identification, UUID> {
}
