package com.vetconnect.vetconnect.services;

import com.vetconnect.vetconnect.dto.VetCenterDTO;
import com.vetconnect.vetconnect.entities.VetCenter;
import com.vetconnect.vetconnect.repositories.VetCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VetCenterService {

    @Autowired
    private VetCenterRepository vetCenterRepository;

    // Metodo para obtener todos los VetCenters
    public List<VetCenterDTO> getAllVetCenters() {
        return vetCenterRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Metodo para crear un nuevo VetCenter
    public VetCenterDTO createVetCenter(VetCenterDTO vetCenterDTO) {
        VetCenter vetCenter = new VetCenter();
        vetCenter.setVetCenterName(vetCenterDTO.getVetCenterName());
        vetCenter.setVetCenterPhone(vetCenterDTO.getVetCenterPhone());
        vetCenter.setVetCenterPhoto(vetCenterDTO.getVetCenterPhoto());
        vetCenter.setDescription(vetCenterDTO.getDescription());

        vetCenter = vetCenterRepository.save(vetCenter);
        return convertToDTO(vetCenter);
    }

    // Metodo para actualizar un VetCenter existente
    public VetCenterDTO updateVetCenter(Long id, VetCenterDTO vetCenterDTO) {
        VetCenter vetCenter = vetCenterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VetCenter not found"));

        vetCenter.setVetCenterName(vetCenterDTO.getVetCenterName());
        vetCenter.setVetCenterPhone(vetCenterDTO.getVetCenterPhone());
        vetCenter.setVetCenterPhoto(vetCenterDTO.getVetCenterPhoto());
        vetCenter.setDescription(vetCenterDTO.getDescription());

        vetCenter = vetCenterRepository.save(vetCenter);
        return convertToDTO(vetCenter);
    }

    // Metodo para eliminar un VetCenter
    public void deleteVetCenter(Long id) {
        if (!vetCenterRepository.existsById(id)) {
            throw new RuntimeException("VetCenter not found");
        }
        vetCenterRepository.deleteById(id);
    }

    // Metodo para convertir una entidad VetCenter en un DTO
    private VetCenterDTO convertToDTO(VetCenter vetCenter) {
        VetCenterDTO dto = new VetCenterDTO();
        dto.setId(vetCenter.getId());
        dto.setVetCenterName(vetCenter.getVetCenterName());
        dto.setVetCenterPhone(vetCenter.getVetCenterPhone());
        dto.setVetCenterPhoto(vetCenter.getVetCenterPhoto());
        dto.setDescription(vetCenter.getDescription());
        return dto;
    }
}
