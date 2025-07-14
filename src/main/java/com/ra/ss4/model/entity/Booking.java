package com.ra.ss4.model.entity;

import com.ra.ss4.model.utils.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingId;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    private String customerName;
    private String customerPhone;
    private LocalDateTime bookingTime;
    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.BOOKED;
}
