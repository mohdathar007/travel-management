package com.athar.travelmanagement.repository;

import com.athar.travelmanagement.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusDAO extends JpaRepository<Bus, Integer> {

}