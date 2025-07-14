package com.ra.ss4.service.imp;

import com.ra.ss4.model.entity.Flight;
import com.ra.ss4.repository.FlightRepository;
import com.ra.ss4.service.FlightService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImp implements FlightService {
    @Autowired
    private FlightRepository flightRepo;

    @Override
    public Page<Flight> findByDepartureContainingIgnoreCaseAndDestinationContainingIgnoreCase(String departure, String destination, Pageable pageable) {
        if (departure == null || destination == null || departure.isEmpty() || destination.isEmpty()) {
            return flightRepo.findAll(pageable);
        }
        return flightRepo.findByDepartureContainingIgnoreCaseAndDestinationContainingIgnoreCase(departure, destination, pageable);
    }

    @Override
    public boolean save(Flight flight) {
        try {
            flightRepo.save(flight);
        }catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Flight findById(Integer id) {
        return flightRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Ko ton tai flight!"));
    }
}
