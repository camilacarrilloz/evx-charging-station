package com.evx.repository;

import com.evx.model.ChargePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChargePointRepository extends JpaRepository<ChargePoint, Long> {
    List<ChargePoint> findByStatus(String status);
}

@PutMapping("/{id}")
public ResponseEntity<ChargePoint> update(@PathVariable Long id, @RequestBody ChargePoint chargePoint) {
    return service.findById(id)
            .map(existing -> {
                existing.setStatus(chargePoint.getStatus());
                return ResponseEntity.ok(service.save(existing));
            })
            .orElse(ResponseEntity.notFound().build());
}