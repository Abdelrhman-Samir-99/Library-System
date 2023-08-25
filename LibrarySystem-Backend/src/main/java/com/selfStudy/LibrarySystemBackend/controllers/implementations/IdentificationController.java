package com.selfStudy.LibrarySystemBackend.controllers.implementations;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.selfStudy.LibrarySystemBackend.controllers.interfaces.IdentificationApi;
import com.selfStudy.LibrarySystemBackend.dtos.IdentificationDTO;
import com.selfStudy.LibrarySystemBackend.services.interfaces.IdentificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IdentificationController implements IdentificationApi {

	private final IdentificationService identificationService;


	@Override
	public ResponseEntity<IdentificationDTO> createNewIdentification(IdentificationDTO identification) {
		if(identification == null) {
			throw new IllegalArgumentException("Identification Object is null");
		}

		return new ResponseEntity<>(identificationService.createNewIdentification(identification), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<IdentificationDTO> updateIdentification(IdentificationDTO identification) {
		if(identification == null) {
			throw new IllegalArgumentException("Identification Object is null");
		}

		return new ResponseEntity<>(identificationService.updateIdentification(identification), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IdentificationDTO> getIdentificationById(UUID identificationId) {
		if(identificationId == null) {
			throw new IllegalArgumentException("Identification ID is null");
		}

		return new ResponseEntity<>(identificationService.getIdentificationById(identificationId), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Void> deleteIdentificationById(UUID identificationId) {
		if(identificationId == null) {
			throw new IllegalArgumentException("Identification ID is null");
		}

		identificationService.deleteIdentificationById(identificationId);
		return ResponseEntity.noContent().build();
	}
}
