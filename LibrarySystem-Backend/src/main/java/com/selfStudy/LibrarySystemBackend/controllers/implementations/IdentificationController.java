package com.selfStudy.LibrarySystemBackend.controllers.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Identification createNewIdentification(@RequestBody Identification identification) {
		if(identification == null) {
			return null; // This should throw an exception.
		}

		return identificationService.createNewIdentification(identification);
	}
}
