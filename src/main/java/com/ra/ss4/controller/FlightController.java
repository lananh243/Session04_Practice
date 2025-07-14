package com.ra.ss4.controller;

import com.ra.ss4.model.entity.Flight;
import com.ra.ss4.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping
    public String showFlights(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              @RequestParam(required = false) String departure,
                              @RequestParam(required = false) String destination,
                              Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Flight> flights = flightService.findByDepartureContainingIgnoreCaseAndDestinationContainingIgnoreCase(departure, destination, pageable);
        model.addAttribute("flights", flights);
        model.addAttribute("currentPage", flights.getNumber());
        model.addAttribute("totalPages", flights.getTotalPages());
        model.addAttribute("departure", departure);
        model.addAttribute("destination", destination);
        return "B2/list-flight";
    }

    @GetMapping("/add")
    public String formAddFlight(Model model) {
        model.addAttribute("flight", new Flight());
        return "B2/add-flight";
    }

    @PostMapping("/add")
    public String addFlight(Flight flight) {
        flightService.save(flight);
        return "redirect:/flights";
    }
}
