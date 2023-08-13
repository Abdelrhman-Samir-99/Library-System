package com.selfStudy.LibrarySystemBackend.services.implementations;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selfStudy.LibrarySystemBackend.exceptions.ResourceNotFoundException;
import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.repositories.IdentificationRepository;
import com.selfStudy.LibrarySystemBackend.services.interfaces.IdentificationService;

@Service
public class IdentificationServiceImpl implements IdentificationService {

	private IdentificationRepository identificationRepository;

	@Autowired // TODO: can I use Lombok to remove this constructor?
	public IdentificationServiceImpl(IdentificationRepository identificationRepository) {
		this.identificationRepository = identificationRepository;
	}

	@Override
	public Identification createNewIdentification(Identification identification) {
		return identificationRepository.save(identification);
	}

	@Override
	public Identification updateIdentification(Identification identification) {
		Optional<Identification> optionalIdentification = identificationRepository.findById(identification.getId());
		if (optionalIdentification.isPresent()) {
			Identification existedIdentification = optionalIdentification.get();
			BeanUtils.copyProperties(identification, existedIdentification);
			return identificationRepository.save(existedIdentification);
		} else {
			throw new IllegalArgumentException("Record not found");
		}
	}

	@Override
	public Identification getIdentification(UUID identificationId) {
		return identificationRepository.findById(identificationId)
								   .orElseThrow(() -> new ResourceNotFoundException("Record not found with id: " + identificationId));
	}
}
