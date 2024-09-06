package com.example.service;

import com.example.model.OrderRequest;
import com.example.model.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(OrderRequest orderRequest);

    OrderResponse getOrderById(Long id);

    List<OrderResponse> findAll();

    void deleteById(Long id);

    OrderResponse updateOrder(Long id, OrderRequest orderRequest);
}
