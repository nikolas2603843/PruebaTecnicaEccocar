package com.nicolas.eccocar.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nicolas.eccocar.application.command.BookingCommandHandler;
import com.nicolas.eccocar.application.command.CreateBookingCommand;
import com.nicolas.eccocar.application.query.BookingQueryService;
import com.nicolas.eccocar.domain.model.Booking;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingQueryService bookingQueryService;
    private final BookingCommandHandler bookingCommandHandler;

    @Autowired
    public BookingController(
            BookingQueryService bookingQueryService,
            BookingCommandHandler bookingCommandHandler) {
        this.bookingQueryService = bookingQueryService;
        this.bookingCommandHandler = bookingCommandHandler;
    }

    @GetMapping
    public ResponseEntity<Long> getTotalBookings() {
        long totalBookings = bookingQueryService.getTotalBookings();
        return ResponseEntity.ok(totalBookings);
    }

    @GetMapping("/data")
    public List<Booking> getAllBookings() {
        return bookingQueryService.getAllBookings();
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Optional<Booking> booking = bookingQueryService.getBookingById(id);
        return booking.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody CreateBookingCommand command) {
        bookingCommandHandler.handle(command);
        String mensaje = "Reserva creada correctamente.";
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

}
