package com.selfStudy.LibrarySystemBackend.services.implementations;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.selfStudy.LibrarySystemBackend.dtos.IdentificationDTO;
import com.selfStudy.LibrarySystemBackend.exceptions.ResourceNotFoundException;
import com.selfStudy.LibrarySystemBackend.mappers.IdentificationMapper;
import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.repositories.IdentificationRepository;
import com.selfStudy.LibrarySystemBackend.services.interfaces.IdentificationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdentificationServiceImpl implements IdentificationService {

	public static final String RECORD_NOT_FOUND_WITH_ID = "Record not found with id: ";
	private final IdentificationRepository identificationRepository;
	private final IdentificationMapper identificationMapper;


	@Override
	public IdentificationDTO createNewIdentification(IdentificationDTO identificationDto) {
		Identification identification = identificationMapper.mapDtoToIdentification(identificationDto);
		return identificationMapper.mapIdentificationToDto(identificationRepository.save(identification));
	}

	@Override
	public IdentificationDTO updateIdentification(IdentificationDTO identificationDto) {
		Optional<Identification> optionalIdentification = identificationRepository.findById(identificationDto.getId());

		Identification existedIdentification = optionalIdentification
													.orElseThrow(() -> new ResourceNotFoundException(
															RECORD_NOT_FOUND_WITH_ID + identificationDto.getId()));
		Identification identification = identificationMapper.mapDtoToIdentification(identificationDto);

		BeanUtils.copyProperties(identification, existedIdentification);

		return identificationMapper.mapIdentificationToDto(identificationRepository.save(existedIdentification));
	}

	@Override
	public IdentificationDTO getIdentificationById(UUID identificationId) {
		Identification identification = identificationRepository.findById(identificationId)
								   .orElseThrow(() -> new ResourceNotFoundException(RECORD_NOT_FOUND_WITH_ID + identificationId));
		return identificationMapper.mapIdentificationToDto(identification);
	}

	@Override
	public void deleteIdentificationById(UUID identificationId) {
		Identification existedIdentification = identificationRepository.findById(identificationId)
				.orElseThrow(() -> new ResourceNotFoundException(RECORD_NOT_FOUND_WITH_ID + identificationId));
		identificationRepository.delete(existedIdentification);
	}
}
