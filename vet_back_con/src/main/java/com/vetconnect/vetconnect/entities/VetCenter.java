package com.vetconnect.vetconnect.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VetCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vet_center_name", nullable = false)
    private String vetCenterName;

    @Column(name = "vet_center_phone", nullable = false)
    private String vetCenterPhone;

    @Column(name = "vet_center_photo")
    private String vetCenterPhoto;

    @Column(name = "description", nullable = true, length = 500)
    private String description;

}
