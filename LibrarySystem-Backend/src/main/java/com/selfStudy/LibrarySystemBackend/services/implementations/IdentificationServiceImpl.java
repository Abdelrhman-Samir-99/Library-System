package com.selfStudy.LibrarySystemBackend.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.repositories.IdentificationRepository;

public class IdentificationServiceImpl implements com.selfStudy.LibrarySystemBackend.services.interfaces.IdentificationService {

	private IdentificationRepository identificationRepository;

	@Autowired // TODO: can I use Lombok to remove this constructor?
	public IdentificationServiceImpl(IdentificationRepository identificationRepository) {
		this.identificationRepository = identificationRepository;
	}

	@Override
	public Identification createNewIdentification(Identification identification) {
		return identificationRepository.save(identification);
	}
}
