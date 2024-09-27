package com.vetconnect.vetconnect.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingDTO {

    private Long id;
    private LocalDateTime appointmentDateTime;
    private String serviceDescription;
    private Long vetCenterId;
    private Long petOwnerId;
}
