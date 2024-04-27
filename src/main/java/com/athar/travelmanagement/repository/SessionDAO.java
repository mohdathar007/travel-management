package com.athar.travelmanagement.repository;

import com.athar.travelmanagement.model.currentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionDAO extends JpaRepository<currentUserSession, Integer> {
    public currentUserSession findByUuid(String uuid);
}
