package com.Booking.Order.repository;

import com.Booking.Order.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.isDelivered = false ORDER BY o.distanceFromWareHouse ASC, o.customer.isPremium DESC, o.placedTime ASC")
    List<Order> findUndeliveredOrdersSorted();

    @Query("SELECT o FROM Order o WHERE o.isDelivered = false AND o.placedTime BETWEEN :startOfDay AND :endOfDay ORDER BY o.distanceFromWareHouse ASC, o.customer.isPremium DESC, o.placedTime ASC")
    List<Order> findUndeliveredOrdersSortedForDay(LocalDateTime startOfDay, LocalDateTime endOfDay);

    @Query("SELECT o FROM Order o WHERE o.isDelivered = true AND o.placedTime BETWEEN :startOfDay AND :endOfDay ORDER BY o.distanceFromWareHouse ASC, o.customer.isPremium DESC, o.placedTime ASC")
    List<Order> findDeliveredOrdersSortedForDay(LocalDateTime startOfDay, LocalDateTime endOfDay);
}
