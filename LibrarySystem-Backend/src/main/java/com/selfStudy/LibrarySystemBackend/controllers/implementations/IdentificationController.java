package com.selfStudy.LibrarySystemBackend.controllers.implementations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.selfStudy.LibrarySystemBackend.controllers.interfaces.IdentificationApi;
import com.selfStudy.LibrarySystemBackend.models.Identification;
import com.selfStudy.LibrarySystemBackend.services.interfaces.IdentificationService;

@RestController
public class IdentificationController implements IdentificationApi {

	private final IdentificationService identificationService;

	@Autowired
	public IdentificationController(IdentificationService identificationService) {
		this.identificationService = identificationService;
	}

	@Override
	public ResponseEntity<Identification> createNewIdentification(Identification identification) {
		if(identification == null) {
			return null; // This should throw an exception.
		}

		return new ResponseEntity<>(identificationService.createNewIdentification(identification), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Identification> updateIdentification(Identification identification) {
		if(identification == null) {
			return null; // This should throw an exception.
		}

		return new ResponseEntity<>(identificationService.updateIdentification(identification), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Identification> getIdentificationById(UUID identificationId) {
		if(identificationId == null) {
			return null; // This should throw an exception.
		}

		return new ResponseEntity<>(identificationService.getIdentificationById(identificationId), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Void> deleteIdentificationById(UUID identificationId) {
		identificationService.deleteIdentificationById(identificationId);
		return ResponseEntity.noContent().build();
	}
}
