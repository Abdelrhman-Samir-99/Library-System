package com.selfStudy.LibrarySystemBackend.services.interfaces;

import java.util.UUID;

import com.selfStudy.LibrarySystemBackend.dtos.IdentificationDTO;

public interface IdentificationService {
	String RECORD_NOT_FOUND_WITH_ID = "Identification record not found with id: ";
	IdentificationDTO createNewIdentification(IdentificationDTO identification);

	IdentificationDTO updateIdentification(IdentificationDTO expected);

	IdentificationDTO getIdentificationById(UUID identificationId);
	void deleteIdentificationById(UUID identificationId);
}
