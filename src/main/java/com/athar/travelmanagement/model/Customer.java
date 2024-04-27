package com.athar.travelmanagement.model;



import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Pattern(regexp = "^[a-zA-Z_ ]*$",message = "Name cannot start with number of symbol")
    private String name;



    @Size(min = 3, max = 20, message = "Password length should be minimun 3")
    private String costumerpassword;
    private String address;

    @Size(min = 10, max = 10,message = "Enter valid mobile length of length 10")
    private String mobileNo;

    @Email
    private String email;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Feedback> feedbackList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Wallet wallet;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Booking> Booking = new ArrayList<>();



}