package com.ra.ss4.repository;

import com.ra.ss4.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
