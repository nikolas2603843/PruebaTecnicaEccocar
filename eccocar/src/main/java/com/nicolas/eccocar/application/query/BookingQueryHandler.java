package com.nicolas.eccocar.application.query;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nicolas.eccocar.domain.model.Booking;
import com.nicolas.eccocar.infrastructure.persistence.BookingWriteRepository;

@Component
public class BookingQueryHandler {

    private final BookingWriteRepository bookingReadRepository;

    @Autowired
    public BookingQueryHandler(BookingWriteRepository bookingReadRepository) {
        this.bookingReadRepository = bookingReadRepository;
    }

    public Optional<Booking> handle(GetBookingQuery query) {
        return bookingReadRepository.findById(query.getId());
    }

    public long handle(GetTotalBookingsQuery query) {
        return bookingReadRepository.count();
    }



}