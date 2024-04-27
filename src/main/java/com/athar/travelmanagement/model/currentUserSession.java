package com.athar.travelmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class currentUserSession {

    @Id
    @Column(unique = true)
    private Integer userId;

    private String uuid;

    private LocalDateTime localDateTime;


}