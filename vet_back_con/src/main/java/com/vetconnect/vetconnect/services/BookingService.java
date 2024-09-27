package com.vetconnect.vetconnect.services;

import com.vetconnect.vetconnect.dto.BookingDTO;
import com.vetconnect.vetconnect.entities.Booking;
import com.vetconnect.vetconnect.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // Obtener todas las reservas
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Crear una nueva reserva
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setAppointmentDateTime(bookingDTO.getAppointmentDateTime());
        booking.setServiceDescription(bookingDTO.getServiceDescription());
        booking.setVetCenterId(bookingDTO.getVetCenterId());
        booking.setPetOwnerId(bookingDTO.getPetOwnerId());

        booking = bookingRepository.save(booking);
        return convertToDTO(booking);
    }

    // Actualizar una reserva existente
    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setAppointmentDateTime(bookingDTO.getAppointmentDateTime());
        booking.setServiceDescription(bookingDTO.getServiceDescription());
        booking.setVetCenterId(bookingDTO.getVetCenterId());
        booking.setPetOwnerId(bookingDTO.getPetOwnerId());

        booking = bookingRepository.save(booking);
        return convertToDTO(booking);
    }

    // Eliminar una reserva
    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found");
        }
        bookingRepository.deleteById(id);
    }

    // Convertir entidad a DTO
    private BookingDTO convertToDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setAppointmentDateTime(booking.getAppointmentDateTime());
        dto.setServiceDescription(booking.getServiceDescription());
        dto.setVetCenterId(booking.getVetCenterId());
        dto.setPetOwnerId(booking.getPetOwnerId());
        return dto;
    }
}
