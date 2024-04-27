package com.athar.travelmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @NotNull
    private String status;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Route route;


    @OneToOne(cascade = CascadeType.ALL)
    private PaymentDetails payment;



}