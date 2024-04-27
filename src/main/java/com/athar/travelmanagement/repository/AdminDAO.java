package com.athar.travelmanagement.repository;

import com.athar.travelmanagement.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {

    public Admin findByMobile(String mobile);

}
