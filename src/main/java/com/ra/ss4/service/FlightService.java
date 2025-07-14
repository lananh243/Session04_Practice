package com.ra.ss4.service;

import com.ra.ss4.model.entity.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FlightService {
    Page<Flight> findByDepartureContainingIgnoreCaseAndDestinationContainingIgnoreCase(String departure, String destination, Pageable pageable);
    boolean save(Flight flight);
    Flight findById(Integer id);
}
