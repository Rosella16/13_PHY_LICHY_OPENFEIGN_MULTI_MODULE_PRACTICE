package com.example.service.serviceImpl;

import com.example.client.CustomerFeignClient;
import com.example.client.ProductFeignClient;
import com.example.model.*;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
private final OrderRepository orderRepository;
private final CustomerFeignClient customerClient;
private final ProductFeignClient productClient;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        List<ProductResponse> products = new ArrayList<>();
        CustomerResponse customerResponse = customerClient.getCustomerById(orderRequest.getCustomerId());
        for (Long productId : orderRequest.getProductId()) {
            ProductResponse productResponse = productClient.getProductById(productId);
            products.add(productResponse);
        }
        return orderRepository.save(orderRequest.toOrder()).toResponse(customerResponse, products);
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        List<ProductResponse> products = new ArrayList<>();
        CustomerResponse customerResponse = customerClient.getCustomerById(order.getCustomerId());
        for (Long productId : order.getProductIds()) {
            ProductResponse productResponse = productClient.getProductById(productId);
            products.add(productResponse);
        }
        return order.toResponse(customerResponse, products);
    }

    @Override
    public List<OrderResponse> findAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            OrderResponse orderResponse = getOrderById(order.getId());
            orderResponses.add(orderResponse);

        }
        return orderResponses;
    }
}
