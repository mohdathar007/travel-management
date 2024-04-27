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
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    @Pattern(regexp = "^[A-Za-z]*",message = "Name cannot start with number of symbol")
    private String adminName;

    @Size(min = 3, max = 20, message = "Password length should be minimun 3")
    private String password;

    @Email
    private String email;

    @Size(min = 10 , max = 10,message = "Enter valid mobile length of length 10")
    private String mobile;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Report> reports = new ArrayList<>();



}