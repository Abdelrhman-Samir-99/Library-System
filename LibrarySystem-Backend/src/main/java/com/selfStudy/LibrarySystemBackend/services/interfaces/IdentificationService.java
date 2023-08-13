package com.selfStudy.LibrarySystemBackend.services.interfaces;


import com.selfStudy.LibrarySystemBackend.models.Identification;

public interface IdentificationService {
	Identification createNewIdentification(Identification identification);

	Identification updateIdentification(Identification expected);
}
