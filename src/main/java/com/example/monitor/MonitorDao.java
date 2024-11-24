package com.example.monitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorDao extends JpaRepository<Monitor, Integer> {
}
