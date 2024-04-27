package com.athar.travelmanagement.repository;

import com.athar.travelmanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>  {

    public Customer findByMobileNo(String mobileNo);


}