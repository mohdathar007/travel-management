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
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer busId;


    private String busType;

    @NotNull
    private String busNumber;

    @NotNull
    private Integer capacity;

    private Integer fare;

    @OneToOne
    private Route route;




}