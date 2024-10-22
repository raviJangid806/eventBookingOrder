package com.Booking.Order.service;

import com.Booking.Order.dto.OrderDTO;
import com.Booking.Order.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<OrderDTO> getUndeliveredOrdersSorted() {
        return orderRepository.findUndeliveredOrdersSorted().stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getUndeliveredOrdersSortedForDay(LocalDateTime startOfDay, LocalDateTime endOfDay) {
        return orderRepository.findUndeliveredOrdersSortedForDay(startOfDay, endOfDay).stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getDeliveredOrdersSortedForDay(LocalDateTime startOfDay, LocalDateTime endOfDay) {
        return orderRepository.findDeliveredOrdersSortedForDay(startOfDay, endOfDay).stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO markOrderAsDelivered(Long id) {
        return orderRepository.findById(id).map(order -> {
            order.setIsDelivered(true);
            order.setUpdatedAt(LocalDateTime.now());
            return modelMapper.map(orderRepository.save(order), OrderDTO.class);
        }).orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }
}

