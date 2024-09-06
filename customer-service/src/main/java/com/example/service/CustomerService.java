package com.example.service;

import com.example.model.Customer;
import com.example.model.CustomerRequest;
import com.example.model.CustomerResponse;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerRequest customerRequest);

    CustomerResponse getCustomerById(Long id);
//    Customer updateCustomer(Long id, String name, String email);
//    void deleteById(Long id);

    List<Customer> findAll();

    Customer updateCustomer(Long id, CustomerRequest customerRequest);

    void deleteById(Long id);
}
