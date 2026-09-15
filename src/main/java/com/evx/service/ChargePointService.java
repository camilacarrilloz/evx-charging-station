package com.evx.service;

import com.evx.model.ChargePoint;
import com.evx.model.ChargePointStatus;
import com.evx.repository.ChargePointRepository;
import com.evx.repository.ChargePointStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChargePointService {

    private final ChargePointRepository repository;
    private final ChargePointStatusRepository statusRepository;

    public ChargePointService(ChargePointRepository repository, ChargePointStatusRepository statusRepository) {
        this.repository = repository;
        this.statusRepository = statusRepository;
    }

    public List<ChargePoint> findAll() {
        return repository.findAll();
    }

    public Optional<ChargePoint> findById(Long id) {
        return repository.findById(id);
    }

    public ChargePoint save(ChargePoint chargePoint) {
        if (chargePoint.getStatus() != null && chargePoint.getStatus().getId() != null) {
            ChargePointStatus fullStatus = statusRepository.findById(chargePoint.getStatus().getId())
                .orElseThrow(() -> new RuntimeException("Status no encontrado"));
            System.out.println("STATUS NAME: " + fullStatus.getName());
            chargePoint.setStatus(fullStatus);
        }
        return repository.save(chargePoint);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}