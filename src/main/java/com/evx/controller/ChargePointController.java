package com.evx.controller;

import com.evx.model.ChargePoint;
import com.evx.service.ChargePointService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/charge-points")
public class ChargePointController {

    private final ChargePointService service;

    public ChargePointController(ChargePointService service) {
        this.service = service;
    }

    @GetMapping
    public List<ChargePoint> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChargePoint> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChargePoint create(@RequestBody ChargePoint chargePoint) {
        return service.save(chargePoint);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}