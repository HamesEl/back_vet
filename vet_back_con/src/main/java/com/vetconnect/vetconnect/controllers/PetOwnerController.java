package com.vetconnect.vetconnect.controllers;

import com.vetconnect.vetconnect.dto.PetOwnerDTO;
import com.vetconnect.vetconnect.services.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/petowners")
public class PetOwnerController {

    @Autowired
    private PetOwnerService petOwnerService;

    @GetMapping
    public List<PetOwnerDTO> getAllPetOwners() {
        return petOwnerService.getAllPetOwners();
    }

    @PostMapping
    public ResponseEntity<PetOwnerDTO> createPetOwner(@RequestBody PetOwnerDTO petOwnerDTO) {
        return ResponseEntity.ok(petOwnerService.createPetOwner(petOwnerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetOwnerDTO> updatePetOwner(@PathVariable Long id, @RequestBody PetOwnerDTO petOwnerDTO) {
        return ResponseEntity.ok(petOwnerService.updatePetOwner(id, petOwnerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetOwner(@PathVariable Long id) {
        petOwnerService.deletePetOwner(id);
        return ResponseEntity.noContent().build();
    }
}