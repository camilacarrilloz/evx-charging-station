package com.evx.repository;

import com.evx.model.ChargePointStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargePointStatusRepository extends JpaRepository<ChargePointStatus, Long> {
}