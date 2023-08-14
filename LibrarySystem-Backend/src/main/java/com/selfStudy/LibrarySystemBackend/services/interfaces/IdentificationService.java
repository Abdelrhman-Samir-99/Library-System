package com.selfStudy.LibrarySystemBackend.services.interfaces;

import java.util.UUID;

import com.selfStudy.LibrarySystemBackend.models.Identification;

public interface IdentificationService {
	Identification createNewIdentification(Identification identification);

	Identification updateIdentification(Identification expected);

	Identification getIdentificationById(UUID identificationId);
	void deleteIdentificationById(UUID identificationId);
}
