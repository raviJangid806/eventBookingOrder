package com.Booking.Order.controller;

import com.Booking.Order.dto.OrderDTO;
import com.Booking.Order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Fetch undelivered orders sorted by distance, priority, and time
    @GetMapping("/undelivered")
    public List<OrderDTO> getUndeliveredOrdersSorted() {
        return orderService.getUndeliveredOrdersSorted();
    }

    // Fetch undelivered orders for a specific day sorted by distance, priority, and time
    @GetMapping("/undelivered/day")
    public List<OrderDTO> getUndeliveredOrdersSortedForDay(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime date) {
        LocalDateTime startOfDay = date.withHour(0).withMinute(0).withSecond(0);
        LocalDateTime endOfDay = date.withHour(23).withMinute(59).withSecond(59);
        return orderService.getUndeliveredOrdersSortedForDay(startOfDay, endOfDay);
    }

    // Fetch delivered orders for a specific day sorted by distance, priority, and time
    @GetMapping("/delivered/day")
    public List<OrderDTO> getDeliveredOrdersSortedForDay(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime date) {
        LocalDateTime startOfDay = date.withHour(0).withMinute(0).withSecond(0);
        LocalDateTime endOfDay = date.withHour(23).withMinute(59).withSecond(59);
        return orderService.getDeliveredOrdersSortedForDay(startOfDay, endOfDay);
    }

    // Mark an order as delivered
    @PutMapping("/{id}/mark-delivered")
    public ResponseEntity<OrderDTO> markOrderAsDelivered(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.markOrderAsDelivered(id));
    }
}
