package com.Booking.Order.service;

import com.Booking.Order.dto.CustomerDTO;
import com.Booking.Order.entities.Customer;
import com.Booking.Order.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<CustomerDTO> getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customer -> modelMapper.map(customer, CustomerDTO.class));
    }

    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        return modelMapper.map(customerRepository.save(customer), CustomerDTO.class);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO updatedCustomerDTO) {
        return customerRepository.findById(id).map(customer -> {
            customer.setFirstName(updatedCustomerDTO.getFirstName());
            customer.setLastName(updatedCustomerDTO.getLastName());
            customer.setEmail(updatedCustomerDTO.getEmail());
            customer.setAddress(updatedCustomerDTO.getAddress());
            customer.setMobileNumber(updatedCustomerDTO.getMobileNumber());
            customer.setUpdatedAt(LocalDateTime.now());
            return modelMapper.map(customerRepository.save(customer), CustomerDTO.class);
        }).orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with id " + id);
        }
        customerRepository.deleteById(id);
    }
}

