package com.vetconnect.vetconnect.controllers;


import com.vetconnect.vetconnect.dto.VetCenterDTO;
import com.vetconnect.vetconnect.services.VetCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vetcenters")
public class VetCenterController {

    @Autowired
    private VetCenterService vetCenterService;

    @GetMapping
    public List<VetCenterDTO> getAllVetCenters() {
        return vetCenterService.getAllVetCenters();
    }

    @PostMapping
    public ResponseEntity<VetCenterDTO> createVetCenter(@RequestBody VetCenterDTO vetCenterDTO) {
        return ResponseEntity.ok(vetCenterService.createVetCenter(vetCenterDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VetCenterDTO> updateVetCenter(@PathVariable Long id, @RequestBody VetCenterDTO vetCenterDTO) {
        return ResponseEntity.ok(vetCenterService.updateVetCenter(id, vetCenterDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVetCenter(@PathVariable Long id) {
        vetCenterService.deleteVetCenter(id);
        return ResponseEntity.noContent().build();
    }
}