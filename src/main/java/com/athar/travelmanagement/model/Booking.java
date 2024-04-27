package com.athar.travelmanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;


    private LocalDate bookingDate;

    private Double bookingAmt;

    private String status;

    //	@JsonIgnore
    @OneToOne
    private TravelPackage packages;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;


    @OneToOne(cascade = CascadeType.ALL)
    private Bus bus;



    }














