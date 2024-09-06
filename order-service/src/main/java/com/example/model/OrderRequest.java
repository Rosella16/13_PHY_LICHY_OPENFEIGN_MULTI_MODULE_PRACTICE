package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OrderRequest {
    private Long customerId;
    private List<Long> productId;

    public Order toOrder() {
        LocalDateTime orderDate = LocalDateTime.now();
        return new Order(null, this.customerId, this.productId, orderDate);
    }
    public Order toOrder(Long orderId) {
        LocalDateTime orderDate = LocalDateTime.now();
        return new Order(orderId, this.customerId, this.productId,orderDate );
    }

}
