package com.athar.travelmanagement.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @Size(min = 10, max = 10, message = "enter valid mobile no.")
    private String mobileNo;

    @Size(min = 3, max = 200, message = "Password length should be minimun 3")
    private String password;


}