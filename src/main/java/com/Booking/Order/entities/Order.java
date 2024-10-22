package com.Booking.Order.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime placedTime;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private String deliveryAddress;
    private Double distanceFromWareHouse;
    private boolean isDelivered;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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


    public void setIsDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public void setDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public boolean isDelivered() {
        return isDelivered;
    }
}
