package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerRequest {
    private String customerName;
    private String email;

    public Customer toCustomer() {
        return new Customer(null, customerName, email);
    }

    public Customer toCustomer(Long id) {
        return new Customer(id, customerName, email);
    }
}
