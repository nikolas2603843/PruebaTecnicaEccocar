package com.nicolas.eccocar.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/* el entity pa saber como esta en db la tabla */
import com.nicolas.eccocar.domain.model.Booking;
/* adaptador que permite interactuar con base de datos (repository) */
import com.nicolas.eccocar.infrastructure.persistence.BookingWriteRepository;

/* operaciones de escritura para cumplir con el CQRS */
@Component
public class BookingCommandHandler {

    /*
     * declaracion del campo instanciando el repository para interactuar con base de
     * datos
     */
    private final BookingWriteRepository bookingRepository;

    @Autowired
    public BookingCommandHandler(BookingWriteRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void handle(CreateBookingCommand command) {
        /*
         * creacion de una reserva usando el comando CreateBookingCommand (que seria un
         * tipado)
         */
        Booking booking = new Booking();
        booking.setNameCustomer(command.getNameCustomer());
        booking.setDate(command.getDate());
        booking.setDescription(command.getDescription());
        /* para escribir en base de datos */
        bookingRepository.save(booking);
    }

}