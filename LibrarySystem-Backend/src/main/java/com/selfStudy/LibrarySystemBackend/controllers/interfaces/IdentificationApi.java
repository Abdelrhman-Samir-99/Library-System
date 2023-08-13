package com.selfStudy.LibrarySystemBackend.controllers.interfaces;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.selfStudy.LibrarySystemBackend.models.Identification;



@RequestMapping("/api/v1/identification")
public interface IdentificationApi {
	@PostMapping
	Identification createNewIdentification(@RequestBody Identification identification);

	@PutMapping("/update")
	Identification updateIdentification(@RequestBody Identification expected);

	@GetMapping("/{identificationId}")
	Identification getIdentification(@PathVariable UUID identificationId);
}
