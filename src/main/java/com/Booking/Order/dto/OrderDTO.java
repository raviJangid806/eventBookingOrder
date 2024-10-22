package com.Booking.Order.dto;

import java.time.LocalDateTime;

public class OrderDTO {

    private Long id;
    private LocalDateTime placedTime;
    private LocalDateTime updatedAt;
    private Long customerId; // Link to the Customer entity
    private String deliveryAddress;
    private Double distanceFromWareHouse;
    private Boolean isDelivered;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPlacedTime() {
        return placedTime;
    }

    public void setPlacedTime(LocalDateTime placedTime) {
        this.placedTime = placedTime;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Double getDistanceFromWareHouse() {
        return distanceFromWareHouse;
    }

    public void setDistanceFromWareHouse(Double distanceFromWareHouse) {
        this.distanceFromWareHouse = distanceFromWareHouse;
    }

    public Boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }
}
