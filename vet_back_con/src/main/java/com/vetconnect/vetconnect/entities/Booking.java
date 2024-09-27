package com.vetconnect.vetconnect.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appointment_date_time", nullable = false)
    private LocalDateTime appointmentDateTime;

    @Column(name = "service_description", length = 255)
    private String serviceDescription;

    @Column(name = "vet_center_id", nullable = false)
    private Long vetCenterId;

    @Column(name = "pet_owner_id", nullable = false)
    private Long petOwnerId;
}
