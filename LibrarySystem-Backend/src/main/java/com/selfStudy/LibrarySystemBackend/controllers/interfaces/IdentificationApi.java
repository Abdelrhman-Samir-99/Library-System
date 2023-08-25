package com.selfStudy.LibrarySystemBackend.controllers.interfaces;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.selfStudy.LibrarySystemBackend.dtos.IdentificationDTO;

@RequestMapping("/api/v1/identification")
public interface IdentificationApi {
	@PostMapping
	ResponseEntity<IdentificationDTO> createNewIdentification(@RequestBody IdentificationDTO identification);

	@PutMapping("/update")
	ResponseEntity<IdentificationDTO> updateIdentification(@RequestBody IdentificationDTO expected);

	@GetMapping("/{identificationId}")
	ResponseEntity<IdentificationDTO> getIdentificationById(@PathVariable UUID identificationId);

	@DeleteMapping("/{identificationId}")
	ResponseEntity<Void> deleteIdentificationById(@PathVariable UUID identificationId);
}
