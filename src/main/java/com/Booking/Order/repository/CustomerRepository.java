package com.Booking.Order.repository;

import com.Booking.Order.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // You can add custom query methods here if needed in the future

}

