package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    @ElementCollection
    private List<Long> productIds;
    private LocalDateTime orderDate;

    public OrderResponse toResponse(CustomerResponse customerResponse, List<ProductResponse> productResponses) {
        return new OrderResponse(id, customerResponse, productResponses, orderDate);
    }


}

