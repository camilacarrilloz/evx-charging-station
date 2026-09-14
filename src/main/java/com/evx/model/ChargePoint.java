package com.evx.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "charge_points")
public class ChargePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "charge_point_id", nullable = false, unique = true)
    private String chargePointId;

    @Column(nullable = false)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getChargePointId() { return chargePointId; }
    public void setChargePointId(String chargePointId) { this.chargePointId = chargePointId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}