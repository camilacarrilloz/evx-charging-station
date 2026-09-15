package com.evx.dto;

import java.time.LocalDateTime;

public class ChargePointResponse {
    private Long id;
    private String chargePointId;
    private String status;
    private LocalDateTime createdAt;

    public ChargePointResponse(Long id, String chargePointId, String status, LocalDateTime createdAt) {
        this.id = id;
        this.chargePointId = chargePointId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getChargePointId() { return chargePointId; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}