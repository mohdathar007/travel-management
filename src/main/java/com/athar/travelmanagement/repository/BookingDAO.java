package com.athar.travelmanagement.repository;

import com.athar.travelmanagement.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDAO extends JpaRepository<Booking, Integer>{

}