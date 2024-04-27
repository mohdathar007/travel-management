package com.athar.travelmanagement.repository;

import com.athar.travelmanagement.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportDAO extends JpaRepository<Report,Integer> {
}
