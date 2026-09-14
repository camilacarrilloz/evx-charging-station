package com.evx.service;

import com.evx.model.ChargePoint;
import com.evx.repository.ChargePointRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChargePointService {

    private final ChargePointRepository repository;

    public ChargePointService(ChargePointRepository repository) {
        this.repository = repository;
    }

    public List<ChargePoint> findAll() {
        return repository.findAll();
    }

    public Optional<ChargePoint> findById(Long id) {
        return repository.findById(id);
    }

    public ChargePoint save(ChargePoint chargePoint) {
        return repository.save(chargePoint);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<ChargePoint> findByStatus(String status) {
        return repository.findByStatus(status);
    }
}