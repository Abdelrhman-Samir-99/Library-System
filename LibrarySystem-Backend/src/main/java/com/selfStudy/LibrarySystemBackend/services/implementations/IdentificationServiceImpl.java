package com.selfStudy.LibrarySystemBackend.services.implementations;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.selfStudy.LibrarySystemBackend.exceptions.ResourceNotFoundException;
import com.selfStudy.LibrarySystemBackend.mappers.IdentificationMapper;
import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.repositories.IdentificationRepository;
import com.selfStudy.LibrarySystemBackend.services.interfaces.IdentificationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdentificationServiceImpl implements IdentificationService {

	private final IdentificationRepository identificationRepository;
	private final IdentificationMapper identificationMapper;


	@Override
	public Identification createNewIdentification(Identification identification) {
		return identificationRepository.save(identification);
	}

	@Override
	public Identification updateIdentification(Identification identification) {
		Optional<Identification> optionalIdentification = identificationRepository.findById(identification.getId());

		Identification existedIdentification = optionalIdentification
													.orElseThrow(() -> new ResourceNotFoundException("Record not found with id: " + identification.getId()));
		BeanUtils.copyProperties(identification, existedIdentification);

		return identificationRepository.save(existedIdentification);
	}

	@Override
	public Identification getIdentificationById(UUID identificationId) {
		return identificationRepository.findById(identificationId)
								   .orElseThrow(() -> new ResourceNotFoundException("Record not found with id: " + identificationId));
	}

	@Override
	public void deleteIdentificationById(UUID identificationId) {
		Identification existedIdentification = identificationRepository.findById(identificationId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found with id: " + identificationId));
		identificationRepository.delete(existedIdentification);
	}
}
