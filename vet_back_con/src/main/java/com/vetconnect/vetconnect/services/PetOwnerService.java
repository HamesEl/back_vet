package com.vetconnect.vetconnect.services;

import com.vetconnect.vetconnect.dto.PetOwnerDTO;
import com.vetconnect.vetconnect.entities.PetOwner;
import com.vetconnect.vetconnect.repositories.PetOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetOwnerService {

    @Autowired
    private PetOwnerRepository petOwnerRepository;

    public List<PetOwnerDTO> getAllPetOwners() {
        return petOwnerRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PetOwnerDTO createPetOwner(PetOwnerDTO petOwnerDTO) {
        PetOwner petOwner = new PetOwner();
        petOwner.setFirstName(petOwnerDTO.getFirstName());
        petOwner.setLastName(petOwnerDTO.getLastName());
        petOwner.setEmail(petOwnerDTO.getEmail());
        petOwner.setPetOwnerPhone(petOwnerDTO.getPetOwnerPhone());

        petOwner = petOwnerRepository.save(petOwner);
        return convertToDTO(petOwner);
    }

    public PetOwnerDTO updatePetOwner(Long id, PetOwnerDTO petOwnerDTO) {
        PetOwner petOwner = petOwnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PetOwner not found"));

        petOwner.setFirstName(petOwnerDTO.getFirstName());
        petOwner.setLastName(petOwnerDTO.getLastName());
        petOwner.setEmail(petOwnerDTO.getEmail());
        petOwner.setPetOwnerPhone(petOwnerDTO.getPetOwnerPhone());

        petOwner = petOwnerRepository.save(petOwner);
        return convertToDTO(petOwner);
    }

    public void deletePetOwner(Long id) {
        if (!petOwnerRepository.existsById(id)) {
            throw new RuntimeException("PetOwner not found");
        }
        petOwnerRepository.deleteById(id);
    }

    private PetOwnerDTO convertToDTO(PetOwner petOwner) {
        PetOwnerDTO dto = new PetOwnerDTO();
        dto.setId(petOwner.getId());
        dto.setFirstName(petOwner.getFirstName());
        dto.setLastName(petOwner.getLastName());
        dto.setEmail(petOwner.getEmail());
        dto.setPetOwnerPhone(petOwner.getPetOwnerPhone());
        return dto;
    }
}
