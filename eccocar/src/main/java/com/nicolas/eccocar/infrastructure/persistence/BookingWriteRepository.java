package com.nicolas.eccocar.infrastructure.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolas.eccocar.domain.model.Booking;

/* adaptadores para interactuar con base de datos JPA */
@Repository
public interface BookingWriteRepository extends JpaRepository<Booking, Long> {
    long count();
}