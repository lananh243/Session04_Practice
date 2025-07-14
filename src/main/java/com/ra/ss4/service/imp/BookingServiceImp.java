package com.ra.ss4.service.imp;

import com.ra.ss4.model.entity.Booking;
import com.ra.ss4.repository.BookingRepository;
import com.ra.ss4.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BookingServiceImp implements BookingService {
    @Autowired
    private BookingRepository bookingRepo;

    @Override
    public boolean save(Booking booking) {
        try {
            bookingRepo.save(booking);
        }catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Page<Booking> findAllBookings(Pageable pageable) {
        return bookingRepo.findAll(pageable);
    }

    @Override
    public Booking findBookingById(Integer id) {
        return bookingRepo.findById(id).orElseThrow(()-> new NoSuchElementException("Khong ton tai booking!"));
    }
}
