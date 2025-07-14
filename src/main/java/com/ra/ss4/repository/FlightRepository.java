package com.ra.ss4.repository;

import com.ra.ss4.model.entity.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Page<Flight> findByDepartureContainingIgnoreCaseAndDestinationContainingIgnoreCase(String departure, String destination, Pageable pageable);
}
