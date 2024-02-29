package com.nicolas.eccocar.application.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.eccocar.domain.model.Booking;
/* adaptador que permite interactuar con base de datos (repository) */
import com.nicolas.eccocar.infrastructure.persistence.BookingWriteRepository;
import java.util.List;
import java.util.Optional;

/* operaciones de lectura para cumplir con erl CQRS */

@Service
public class BookingQueryService {
    /*
     * declaracion del campo instanciando el repository para interactuar con base de
     * datos
     */
    private final BookingWriteRepository bookingRepository;

    @Autowired
    public BookingQueryService(BookingWriteRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /* obtener todas las reservas de base de datos */
    public List<Booking> getAllBookings() {
        /* en JpaRepository ya existen los mjetodos como finAll,findById,save */
        return bookingRepository.findAll();
    }

    /* consultar la resrva por id en base de datos */
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public long getTotalBookings() {
        return bookingRepository.count();
    }
}