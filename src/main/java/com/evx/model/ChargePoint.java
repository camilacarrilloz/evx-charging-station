package com.evx.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
@Table(name = "charge_points")
public class ChargePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El Charge Point ID debe tener el formato CP-XXX (ej: CP-001)")
    @Pattern(
        regexp = "^CP-\\d{3}$",
        message = "El Charge Point ID debe tener el formato CP-XXX (ej: CP-001)"
    )
    @Column(name = "charge_point_id", nullable = false, unique = true)
    private String chargePointId;

    @NotNull(message = "El status no puede estar vacío")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", nullable = false)
    private ChargePointStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getChargePointId() { return chargePointId; }
    public void setChargePointId(String chargePointId) { this.chargePointId = chargePointId; }
    public ChargePointStatus getStatus() { return status; }
    public void setStatus(ChargePointStatus status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}