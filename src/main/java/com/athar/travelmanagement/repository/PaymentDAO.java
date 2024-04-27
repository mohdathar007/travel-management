package com.athar.travelmanagement.repository;

import com.athar.travelmanagement.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDAO extends JpaRepository<PaymentDetails, Integer> {

}