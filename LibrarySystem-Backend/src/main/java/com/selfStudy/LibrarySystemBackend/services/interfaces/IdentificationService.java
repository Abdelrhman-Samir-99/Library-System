package com.selfStudy.LibrarySystemBackend.services.interfaces;

import org.springframework.stereotype.Service;

import com.selfStudy.LibrarySystemBackend.models.Identification;

@Service
public interface IdentificationService {
	Identification createNewIdentification(Identification identification);
}
