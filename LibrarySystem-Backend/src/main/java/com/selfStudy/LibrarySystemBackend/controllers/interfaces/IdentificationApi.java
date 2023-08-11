package com.selfStudy.LibrarySystemBackend.controllers.interfaces;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selfStudy.LibrarySystemBackend.models.Identification;


@RestController
@RequestMapping("/api/v1/identification")
public interface IdentificationApi {
	@PostMapping
	Identification createNewIdentification(Identification identification);
}
