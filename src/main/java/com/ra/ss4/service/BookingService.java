package com.ra.ss4.service;

import com.ra.ss4.model.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingService {
    boolean save(Booking booking);
    Page<Booking> findAllBookings(Pageable pageable);
    Booking findBookingById(Integer id);
}
