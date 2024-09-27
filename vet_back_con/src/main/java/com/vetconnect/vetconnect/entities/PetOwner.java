package com.vetconnect.vetconnect.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PetOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "pet_owner_phone", nullable = false)
    private String petOwnerPhone;

}
