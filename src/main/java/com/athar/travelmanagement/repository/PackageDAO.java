package com.athar.travelmanagement.repository;

import com.athar.travelmanagement.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageDAO extends JpaRepository<TravelPackage, Integer>{

}