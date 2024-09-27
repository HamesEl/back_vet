package com.vetconnect.vetconnect.dto;

import lombok.Data;

@Data
public class PetOwnerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String petOwnerPhone;

}
