package com.athar.travelmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private LocalDate time;
    private String name;
    private String address;
    private Double TotalAmount;
    private String Status;



    @OneToOne(cascade = CascadeType.ALL)
    private Booking booking;



}
