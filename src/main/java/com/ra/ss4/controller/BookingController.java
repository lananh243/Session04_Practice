package com.ra.ss4.controller;

import com.ra.ss4.model.entity.Booking;
import com.ra.ss4.model.entity.Flight;
import com.ra.ss4.model.utils.BookingStatus;
import com.ra.ss4.service.BookingService;
import com.ra.ss4.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private FlightService flightService;

    @GetMapping
    public String bookings(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "5") int size,
                           Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Booking> bookings = bookingService.findAllBookings(pageable);
        model.addAttribute("bookings", bookings);
        model.addAttribute("currentPage", bookings.getNumber());
        model.addAttribute("totalPages", bookings.getTotalPages());
        return "B2/bookings";
    }
    @GetMapping("/create/{flightId}")
    public String showBookingForm(@PathVariable Integer flightId, Model model) {
        Flight flight = flightService.findById(flightId);
        Booking booking = new Booking();
        booking.setFlight(flight);
        model.addAttribute("booking", booking);
        model.addAttribute("flight", flight);
        return "B2/booking-form";
    }

    @PostMapping("/add")
    public String addBooking(Booking booking) {
        bookingService.save(booking);
        return "redirect:/bookings";
    }

    @GetMapping("/cancel/{bookingId}")
    public String cancelBooking(@PathVariable Integer bookingId) {
        Booking booking = bookingService.findBookingById(bookingId);
        if (booking != null && booking.getStatus() == BookingStatus.BOOKED) {
            booking.setStatus(BookingStatus.CANCELLED);
            bookingService.save(booking);
        }
        return "redirect:/bookings";
    }
}
