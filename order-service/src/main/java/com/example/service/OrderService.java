package com.example.service;

import com.example.model.OrderRequest;
import com.example.model.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(OrderRequest orderRequest);

    OrderResponse getOrderById(Long id);
}
