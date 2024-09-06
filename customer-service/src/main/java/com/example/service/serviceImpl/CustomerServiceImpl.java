package com.example.service.serviceImpl;

import com.example.model.Customer;
import com.example.model.CustomerRequest;
import com.example.model.CustomerResponse;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public Customer createCustomer(CustomerRequest customerRequest) {
        return customerRepository.save(customerRequest.toCustomer());
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(null);
        if (customer ==null) {throw new IllegalStateException("Customer not found with ID" + id);
        }
        return customer.toResponse();
    }


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return customerRepository.save(customerRequest.toCustomer());
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
