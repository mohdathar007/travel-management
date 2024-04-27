package com.athar.travelmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer packageId;

    @NotNull
    private String packageName;
    private String packageDescription;


    @NotNull
    private Double packageCost;

    private Integer NoOfDays;

    private Integer pax;

//	@JsonIgnore
//	@OneToOne(cascade = CascadeType.ALL)
//	private Booking booking;


    @OneToOne(cascade = CascadeType.ALL)
    private Hotel hotel;






}