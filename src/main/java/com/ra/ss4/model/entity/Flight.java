package com.ra.ss4.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "flights")
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Integer flightId;
    private String flightNumber;
    private String departure;
    private String destination;
    private double price;

    public String getFormattedPrice() {
        return String.format("%,.0f ₫", price).replace(",", ".");
    }
}
